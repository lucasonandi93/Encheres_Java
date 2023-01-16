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
		UserManager userManager = new UserManager();
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
			System.out.println(request.getParameter("deconnexion"));
			
			if (request.getParameter("deconnexion") == "true") {
				
				session.setAttribute("user", null);
				
			}
			
			System.out.println(session.getAttribute("user"));
			
			
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
		
		System.out.println("doPost");
		try {
			if (request.getParameter("pseudo") != null && request.getParameter("password") != null) {
				User userOngoing = null;
				if (request.getParameter("name") != null) {
					userOngoing = new User(request.getParameter("pseudo"),
							request.getParameter("name"),
							request.getParameter("firstName"),
							request.getParameter("email"),
							request.getParameter("street"),
							request.getParameter("cp"),
							request.getParameter("city"),
							request.getParameter("password"));
					if (request.getParameter("tel") != "" || request.getParameter("tel") != null) {
						userOngoing.setPhone(request.getParameter("tel"));
					}
					 
					userManager.addData(userOngoing);
				}else {
					
					if (request.getParameter("souvenir") != null) {
						String pseudo = request.getParameter("pseudo");
						String password = request.getParameter("password");
						
						Cookie cookie1 = new Cookie("pseudo", pseudo);
						cookie1.setMaxAge(60 * 60 * 24 * 30);
						response.addCookie(cookie1);
						
						Cookie cookie2 = new Cookie("password", password);
						// durée de vie du cookie en secondes 
						// (ici 60 sec x60 min x24h x30 jours = 30 jours)
						cookie2.setMaxAge(60 * 60 * 24 * 30);
						response.addCookie(cookie2);
						
						userOngoing.setPseudo(request.getParameter("pseudo"));
						userOngoing.setPseudo(request.getParameter("password"));
						
					}
					
					userOngoing = userManager.selectByPseudoMdp(request.getParameter("pseudo"), request.getParameter("password"));
				
					
					session.setAttribute("user", userOngoing);
				}
			} else {
				session.setAttribute("user", null);
				
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
