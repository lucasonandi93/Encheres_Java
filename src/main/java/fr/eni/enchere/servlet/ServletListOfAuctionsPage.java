package fr.eni.enchere.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.AuctionManager;
import fr.eni.enchere.bll.CategoryManager;
import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.exceptions.BusinessException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class test
 */
@WebServlet("/ServletListOfAuctionsPage")
public class ServletListOfAuctionsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListOfAuctionsPage() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	public void init() throws ServletException {
		User userOngoing = new User();

		userOngoing.setNoUser(0);

		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			if (request.getParameter("deconnexion") != null) {

				session.setAttribute("user", null); 

			}

			displayCategories(request);

			List<Article> articleListToDisplay = deconnectedFilter(request);

			if (session.getAttribute("user") != null && request.getParameter("filter") != null) {
				articleListToDisplay = connectedFilter(articleListToDisplay, request, session);
			}

			if (articleListToDisplay != null) {
				request.setAttribute("articleList", articleListToDisplay);
			}

		} catch (BusinessException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/jsp/homePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryManager categoryManager = new CategoryManager();
		UserManager userManager = new UserManager();
		ArticleManager articleManager = new ArticleManager();
		AuctionManager auctionManager = new AuctionManager();
		HttpSession session = request.getSession();

		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("password");

		try {

			User userOngoing = new User();
			// Connection ou Enregistrement ou Modification ou Suppression
			if (pseudo != null && password != null) {
				// Enregistrement ou Modification ou Suppression
				if (request.getParameter("name") != null) {
					userOngoing = new User(pseudo, request.getParameter("name"), request.getParameter("firstName"),
							request.getParameter("email"), request.getParameter("street"), request.getParameter("cp"),
							request.getParameter("city"), password);
					if (request.getParameter("tel") != "" || request.getParameter("tel") != null) {
						userOngoing.setPhone(request.getParameter("tel"));
					}
					// Modification ou Suppression
					if (request.getParameter("save") != null || request.getParameter("delete") != null) {
						userOngoing.setNoUser(((User) session.getAttribute("user")).getNoUser());
						// Modification
						if (request.getParameter("save") != null) {
							userManager.updateData(userOngoing);
							// Suppression
						} else if (request.getParameter("delete") != null) {
							userManager.deleteData(userOngoing.getNoUser());
							userOngoing.setNoUser(0);
						}
						// Enregistrement
					} else if (request.getParameter("validate") != null) {
						userManager.addData(userOngoing);
					}
					// Connection
				} else {
					// Se souvenir de moi
					if (request.getParameter("souvenir") != null) {

						Cookie cookie1 = new Cookie("pseudo", pseudo);
						// durée de vie du cookie en secondes
						// (ici 60 sec x60 min x24h x30 jours = 30 jours)
						cookie1.setMaxAge(60 * 60 * 24 * 30);
						response.addCookie(cookie1);

						Cookie cookie2 = new Cookie("password", password);
						cookie2.setMaxAge(60 * 60 * 24 * 30);
						response.addCookie(cookie2);
					}

					userOngoing.setPseudo(pseudo);
					userOngoing.setPassword(password);

					userOngoing = userManager.selectByPseudoMdp(pseudo, password);

				}
			}

			if (userOngoing.getNoUser() != 0) {
				session.setAttribute("user", userOngoing);
			}

			if (request.getParameter("addArticle") != null) {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

				Article articleOngoing = new Article();
				articleOngoing.setNameArticle(request.getParameter("articleName"));
				articleOngoing.setDescription(request.getParameter("articleDescription"));
				articleOngoing.setCategory(categoryManager.selectByName(request.getParameter("articleCategorie")));
				articleOngoing.setOriginalPrice(Integer.parseInt(request.getParameter("articleOriginalPrice")));
				articleOngoing.setSellingPrice(Integer.parseInt(request.getParameter("articleOriginalPrice")));
				Date startDate = formatter.parse(request.getParameter("articleStartDate"));

				articleOngoing.setAuctionStartDate(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

				Date endtDate = formatter.parse(request.getParameter("articleEndDate"));
				articleOngoing.setAuctionEndDate(endtDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

				Withdrawal withdrawalOngoing = new Withdrawal();

				withdrawalOngoing.setStreet(request.getParameter("withdrawalStreet"));
				withdrawalOngoing.setCp(request.getParameter("withdrawalCp"));
				withdrawalOngoing.setCity(request.getParameter("withdrawalCity"));

				articleOngoing.setWithdrawal(withdrawalOngoing);

				articleOngoing.setUser(userManager.selectById(((User) session.getAttribute("user")).getNoUser()));

				articleManager.addData(articleOngoing);
			}

			// si proposition d'enchère
			if (request.getParameter("proposal") != null) {
				if (request.getParameter("auction") != null && Integer.parseInt(request.getParameter("auction")) != 0) {
					System.out.println(request.getParameter("articleID"));
					Auction auctionOngoing = new Auction();
					Article articleOngoing = articleManager
							.selectById(Integer.parseInt(request.getParameter("articleID")));
					
					// vérifier qu'elle soit supérieure à l'enchère en cours
					if (Integer.parseInt(request.getParameter("auction")) > articleOngoing.getSellingPrice()) {
						// setter tous les attributs nécessaires : montant, ID artcile et ID user
						auctionOngoing.setAuctionAmount(Integer.parseInt(request.getParameter("auction")));
						auctionOngoing.setArticle(articleOngoing);
						auctionOngoing.setUser((User) session.getAttribute("user"));

						// ajout enchère dans la BDD
						auctionManager.addData(auctionOngoing);

						// remplacer valeur enchère en cours par ma proposition dans "meilleure offre"
						articleOngoing.setSellingPrice(auctionOngoing.getAuctionAmount());
						
						// mettre à jour le sellingPrice de l'article
						articleManager.updateData(articleOngoing, request);
						
						System.out.println(articleOngoing);
					}
				}
			}

		} catch (BusinessException | ParseException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

	private List<Article> deconnectedFilter(HttpServletRequest request) throws BusinessException {

		// RECUPERATION DE LA CATEGORIE SELECTIONNEE
		// Déclaration du CategoryManager
		CategoryManager categoryManager = new CategoryManager();
		// Déclaration et Initialisation de la categorie sélectionnée
		Category categoryOngoing = categoryManager.selectByName(request.getParameter("categories"));
		String categories = request.getParameter("categories");

		// RECUPERATION DU CONTENU QUE DOIT CONTENIR LE NOM DE L'ARTICLE
		String content = request.getParameter("content");

		// Déclaration du ArticleManager
		ArticleManager articleManager = new ArticleManager();

		// Déclaration d'une liste d'articles vide
		List<Article> articleListDeconnectedFilter = null;
		// Si aucun filtre n'est utilisé
		if (request.getParameter("content") == null || ("".equals(content) && "Toutes".equals(categories))) {
			// Récupérer l'ensemble des articles
			articleListDeconnectedFilter = articleManager.selectAll();
			// Si le filtre categorie est utilisé
		} else if (("".equals(content) && !("Toutes".equals(categories)))) {
			// Récupérer les articles qui ont font partie de la categorie selectionnée
			articleListDeconnectedFilter = articleManager.selectByNoCategory(categoryOngoing.getNoCategory());
			// Si le filtre content est utilisé
		} else if (!("".equals(content)) && "Toutes".equals(categories)) {
			// Récupérer les articles qui contiennent la chaine de caractère saisie
			articleListDeconnectedFilter = articleManager.selectByName(content);
			// Si les 2 filtres sont utilisés
		} else if ((!("".equals(content)) && !("Toutes".equals(categories)))) {
			// Récupérer les articles qui contiennent la chaine de caractère saisie et font
			// partie de la categorie selectionnée
			articleListDeconnectedFilter = articleManager.selectByNoCategoryAndName(categoryOngoing.getNoCategory(),
					content);
		}
		

		return articleListDeconnectedFilter;
	}

	private List<Article> connectedFilter(List<Article> articleList, HttpServletRequest request, HttpSession session)
			throws BusinessException {
		
		
		if ("mes enchères".equals(request.getParameter("filter")) || "mes enchères remportées".equals(request.getParameter("filter"))) {
			ArticleManager articleManager = new ArticleManager();
			AuctionManager auctionManager = new AuctionManager();
			
			List<Auction> listUserConnectedAuctions = auctionManager.selectByNoUser(((User) session.getAttribute("user")).getNoUser());
			
			List<Article> articleListB = new ArrayList<>();
			
			for (Auction auction : listUserConnectedAuctions) {
				Article articleOngoing = articleManager.selectById(auction.getArticle().getNoArticle());
				if (!articleListB.contains(articleOngoing)) {
					articleListB.add(articleOngoing);
				}
			}
			
			articleList = articleListB;
		}
		
		List<Article> articleListConnectedFilter = new ArrayList<>();

		for (Article article : articleList) {
			boolean isStartDate = (article.getAuctionStartDate().equals(LocalDate.now()));
			boolean isEndDate = (article.getAuctionEndDate().equals(LocalDate.now()));
			boolean isBeforeStartDate = (article.getAuctionStartDate().isAfter(LocalDate.now()));
			boolean isAfterStartDate = (article.getAuctionStartDate().isBefore(LocalDate.now()));
			boolean isBeforeEndDate = (article.getAuctionEndDate().isAfter(LocalDate.now()));
			boolean isAfterEndDate = (article.getAuctionEndDate().isBefore(LocalDate.now()));
			boolean isUserConnectedArticle = article.getUser().getNoUser() == ((User) session.getAttribute("user")).getNoUser();
			switch (request.getParameter("filter")) {
			case "enchères ouvertes":
				if ((isAfterStartDate || isStartDate && isBeforeEndDate || isEndDate)) {
					articleListConnectedFilter.add(article);
				}
				break;
			case "mes enchères": 
				if ((isAfterStartDate || isStartDate) && (isBeforeEndDate || isEndDate)) {
					articleListConnectedFilter.add(article);
				}
				break;
			case "mes ventes en cours":
				if ((isAfterStartDate || isStartDate) && (isBeforeEndDate || isEndDate) && isUserConnectedArticle) {
					articleListConnectedFilter.add(article);
				}
				break;
			case "mes ventes non débutées":
				if (isBeforeStartDate && isUserConnectedArticle) {
					articleListConnectedFilter.add(article);
				}
				break;
			case "mes ventes terminées":
				if (isAfterEndDate && isUserConnectedArticle) {
					articleListConnectedFilter.add(article);
				}
				break;
			default:
				break;
			}
		}

		return articleListConnectedFilter;
	}

	private void displayCategories(HttpServletRequest request) throws BusinessException {
		// AFFICHAGE DES DIFFERENTES CATEGORIES
		// Déclaration du CategoryManger
		CategoryManager categoryManager = new CategoryManager();

		// Déclaration et Initialisation de la liste de categories
		List<Category> categoryList = categoryManager.selectAll();

		// Setter la liste de categories dans un attribut de requète
		if (!categoryList.isEmpty()) {
			request.setAttribute("categoryList", categoryList);
		}
	}

}
