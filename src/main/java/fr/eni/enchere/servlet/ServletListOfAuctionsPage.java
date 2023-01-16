package fr.eni.enchere.servlet;

import java.io.IOException;
 
import java.util.List;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.CategoryManager;
import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.User;
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
		ArticleManager articleManager = new ArticleManager();
		CategoryManager categoryManager = new CategoryManager();
		List<Article> articleList = null;
		List<Category> categoryList = null;
		
		
		try {

			categoryList = categoryManager.selectAll();
			request.setAttribute("categoryList", categoryList);

			Category categoryOngoing = categoryManager.selectByName(request.getParameter("categories"));

			String content = request.getParameter("content");

			String categories = request.getParameter("categories");

			HttpSession session = request.getSession();
			
			if (request.getParameter("content") == null || 
					("".equals(content) &&  "Toutes".equals(categories))) {
				articleList = articleManager.selectAll();
			} else if (("".equals(content) && !("Toutes".equals(categories)))) {
				articleList = articleManager.selectByNoCategory(categoryOngoing.getNoCategory());
			} else if (!("".equals(content)) && "Toutes".equals(categories)) {
				articleList = articleManager.selectByName(content);
			} else if ((!("".equals(content)) && !("Toutes".equals(categories)))) {
				articleList = articleManager.selectByNoCategoryAndName(categoryOngoing.getNoCategory(),content);
			}
			
			if  (articleList != null) {
				request.setAttribute("articleList", articleList);
			}
	
			
			if (request.getParameter("deconnexion") != null) {
				
				session.setAttribute("user", null);
				
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

		UserManager userManager = new UserManager();
		HttpSession session = request.getSession();
		
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("password");
		
		try {
			User userOngoing = new User();
			//Connection ou Enregistrement ou Modification ou Suppression
			if (pseudo != null && password != null) {
				//Enregistrement ou Modification ou Suppression
				if (request.getParameter("name") != null) {
					userOngoing = new User(pseudo,
							request.getParameter("name"),
							request.getParameter("firstName"),
							request.getParameter("email"),
							request.getParameter("street"),
							request.getParameter("cp"),
							request.getParameter("city"),
							password);
					if (request.getParameter("tel") != "" || request.getParameter("tel") != null) {
						userOngoing.setPhone(request.getParameter("tel"));
					}
					//Modification ou Suppression
					if (request.getParameter("save") != null || request.getParameter("delete") != null) {
						userOngoing.setNoUser(((User)session.getAttribute("user")).getNoUser());
						//Modification
						if (request.getParameter("save") != null) {
							userManager.updateData(userOngoing);
						//Suppression
						}else if (request.getParameter("delete") != null) {
							userManager.deleteData(userOngoing.getNoUser());
							userOngoing.setNoUser(0);
						}
					//Enregistrement	
					}else if (request.getParameter("validate") != null) {
						userManager.addData(userOngoing);
					}
				//Connection	
				}else {
					//Se souvenir de moi
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
			
			System.out.println(userOngoing);
			
			if (userOngoing.getNoUser() != 0){
				session.setAttribute("user", userOngoing);
			}else {
				session.setAttribute("user", null);
			}
			
			
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
