package fr.eni.enchere.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
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

/**
 * Servlet implementation class ServletTestBLL
 */
@WebServlet("/ServletTestBLL")
public class ServletTestBLL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTestBLL() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleManager articleManager = new ArticleManager();
		AuctionManager auctionManager = new AuctionManager();
		UserManager userManager = new UserManager();
		CategoryManager categoryManager = new CategoryManager();

		// Déclaration et instanciation de POJO
		User alexandra = new User("Masque_Panda", "Boulay", "Alexandra", "alex.boulay@orange.fr", "07-85-66-90-96",
				"rue de la foret", "53540", "LAUBRIERES", "quiqui35", 1000, false);
		User luca = new User("Iromega", "Dupont", "Luca", "leboss@gmail.com", "02 90 66 55 22", "rue du pendu", "35500",
				"VITRE", "bidon25", 250, false);
		User alban = new User("Ferach", "Ferrera", "Alban", "banban.ferach@orange.fr", "06 52 33 29 52",
				"rue des perdus", "85600", "AMIENS", "leclown", 3000, true);

		Auction auction1 = new Auction(LocalDate.of(2023, 02, 23), 200, 1, 2);
		Auction auction2 = new Auction(LocalDate.of(2023, 03, 11), 100, 1, 5);
		Auction auction3 = new Auction(LocalDate.of(2023, 02, 01), 50, 2, 4);
		Auction auction4 = new Auction(LocalDate.of(2023, 01, 26), 1000, 2, 3);
		Auction auction5 = new Auction(LocalDate.of(2023, 01, 22), 10, 3, 1);

		Withdrawal withdrawal = new Withdrawal(1, "rue de la foret", "53540", "LAUBRIERES");
		Withdrawal withdrawa2 = new Withdrawal(2, "rue du pendu", "35500", "VITRE");
		Withdrawal withdrawa3 = new Withdrawal(3, "rue des perdus", "85600", "AMIENS");
		Withdrawal withdrawa4 = new Withdrawal(4, "rue de la foret", "53540", "LAUBRIERES");
		Withdrawal withdrawa5 = new Withdrawal(5, "rue de la foret", "53540", "LAUBRIERES");

		Article pcGamer = new Article("PC Gamer 3000", "Un super PC fixe avec de grosses performances",
				LocalDate.of(2023, 01, 20), LocalDate.of(2023, 02, 01), 1, 1, withdrawal);
		Article table = new Article("Table Ronde", "Une table ronde qui fait un mêtre de haut",
				LocalDate.of(2023, 02, 20), LocalDate.of(2023, 02, 25), 2, 2, withdrawa2);
		Article ballon = new Article("Ballon de foot", "Ballon de l'équipe de france signé par tous les joueurs",
				LocalDate.of(2023, 01, 25), LocalDate.of(2023, 02, 03), 3, 4, withdrawa3);
		Article slip = new Article("Slip sale", "Un slip avec une grosse trace de pneu", LocalDate.of(2023, 01, 29),
				LocalDate.of(2023, 03, 02), 1, 3, withdrawa4);
		Article souris = new Article("Souris sans fil", "Une souris sans fil (Connection Bluetooth)",
				LocalDate.of(2023, 03, 10), LocalDate.of(2023, 03, 12), 2, 1, withdrawa5);

		try {
			// =======================================================================================================================================

			// METHODES INSERT
			// Test de la méthode insert de userManager
			userManager.addData(alexandra);
			userManager.addData(luca);
			userManager.addData(alban);
			// Test avec erreur
			userManager.addData(null);
			// Test de la méthode insert de articleManager
			articleManager.addData(pcGamer);
			articleManager.addData(table);
			articleManager.addData(ballon);
			articleManager.addData(slip);
			articleManager.addData(souris);
			// Test avec erreur

			// Test de la méthode insert de auctionManager
			auctionManager.addData(auction1);
			auctionManager.addData(auction2);
			auctionManager.addData(auction3);
			auctionManager.addData(auction4);
			auctionManager.addData(auction5);
			// Test avec erreur
			
			// =======================================================================================================================================
			System.out.println("============================================================================================");
			// METHODES SELECTALL
			// Test de la méthode selectall de userManager
			List<User> userList = userManager.selectAll();

			for (User user : userList) {
				System.out.println(user);
			}

			// Test de la méthode selectall de articleManager
			List<Article> articleList = articleManager.selectAll();

			for (Article article : articleList) {
				System.out.println(article);
			}

			// Test de la méthode selectall de auctionManager
			List<Auction> auctionList = auctionManager.selectAll();

			for (Auction auction : auctionList) {
				System.out.println(auction);
			}

			// =======================================================================================================================================

			// METHODES UPDATE
			// Test de la méthode update de userManager
			alexandra = new User("BB_Panda", "Boulay", "Alexandra", "alex.boulay@orange.fr", "07-85-66-90-96",
					"rue de la foret", "53540", "LAUBRIERES", "quiqui35", 1000, false);
			userManager.updateData(alexandra);
			// Test avec erreur

			// Test de la méthode update de articleManager
			pcGamer = new Article("PC Gamer cassé", "Un super PC fixe avec de grosses performances",
					LocalDate.of(2023, 01, 20), LocalDate.of(2023, 02, 01), 1, 1, withdrawal);
			articleManager.updateData(pcGamer);
			// Test avec erreur

			// Test de la méthode update de auctionManager
			auction1 = new Auction(LocalDate.of(2023, 02, 23), 500, 1, 2);
			auctionManager.updateData(auction1);
			// Test avec erreur

			// =======================================================================================================================================
			System.out.println(
					"============================================================================================");

			// METHODES SELECTBYID
			// Test de la méthode selectbyid de userManager
			User user = userManager.selectById(1);
			System.out.println(user);
			// Test avec erreur

			// Test de la méthode selectbyid de articleManager
			Article article = articleManager.selectById(1);
			System.out.println(article);
			// Test avec erreur

			// Test de la méthode selectbyid de auctionManager
			Auction auction = auctionManager.selectById(1);
			System.out.println(auction);
			// Test avec erreur

			// =======================================================================================================================================

			// METHODES DELETE
			// Test de la méthode delete de userManager
			userManager.deleteData(3);
			// Test avec erreur

			// Test de la méthode delete de articleManager
			articleManager.deleteData(1);
			// Test avec erreur

			// Test de la méthode delete de auctionManager
			auctionManager.deleteData(1);
			// Test avec erreur

			// =======================================================================================================================================

			// METHODE SELECTBYPSEUDOMDP USER
			User userConnexion = userManager.selectByPseudoMdp("Iromega", "bidon25");
			System.out.println("============================================================================================");
			System.out.println(userConnexion);
			// =======================================================================================================================================

			// METHODE SELECTBYNOCATEGORY ARTICLE
			// Test de la méthode selectByNoCategory de articleManager
			List<Article> articleListByNoCategory = articleManager.selectByNoCategory(1);
			System.out.println("============================================================================================");
				for (Article article2 : articleListByNoCategory) {
					System.out.println(article2);
				}
			// Test avec erreur

			// =======================================================================================================================================

				// METHODE SELECTBYCHARNAME ARTICLE
				// Test de la méthode selectByCharName de articleManager
				List<Article> articleListCharName = articleManager.selectByName("PC");
				System.out.println("============================================================================================");
				for (Article article3 : articleListCharName) {
					System.out.println(article3);
				}
				// Test avec erreur

				// =======================================================================================================================================
	
				// METHODE SELECTBYCHARNAMEANDNOCATEGORY ARTICLE
				// Test de la méthode selectByNoCategoryAndCharName de articleManager
				List<Article> articleListCharNameAndNoCategory = articleManager.selectByNoCategoryAndName(1, "PC");
				System.out.println("============================================================================================");
				for (Article article4 : articleListCharNameAndNoCategory) {
					System.out.println(article4);
				}
				// Test avec erreur
	
				// =======================================================================================================================================
	
				// METHODE SELECTALL CATEGORY
				// Test de la méthode selectAll de categoryManager
				List<Category> categoryList = categoryManager.selectAll();
				System.out.println("============================================================================================");
				for (Category category : categoryList) {
					System.out.println(category);
				}
	
		} catch (Exception e) {
			// TODO: handle exception
		}

		request.getRequestDispatcher("/WEB-INF/jsp/listOfAuctionsPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
