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

			if (request.getParameter("content") == null || ("".equals(request.getParameter("content")) && "Toutes".equals(request.getParameter("categories")))) {
				articleList = articleManager.selectAll();
				request.setAttribute("articleList", articleList);
			} else if (("".equals(request.getParameter("content"))
					&& !("Toutes".equals(request.getParameter("categories"))))) {
				articleList = articleManager.selectByNoCategory(categoryOngoing.getNoCategory());
				request.setAttribute("articleList", articleList);
			} else if (!("".equals(request.getParameter("content")))
					&& "Toutes".equals(request.getParameter("categories"))) {
				articleList = articleManager.selectByName(request.getParameter("content"));
				request.setAttribute("articleList", articleList);
			} else if ((!("".equals(request.getParameter("content")))
					&& !("Toutes".equals(request.getParameter("categories"))))) {
				articleList = articleManager.selectByNoCategoryAndName(categoryOngoing.getNoCategory(),
						request.getParameter("content"));
				request.setAttribute("articleList", articleList);
			} else {
				articleList = null;
			}
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/listOfAuctionsPage.jsp").forward(request, response);
		System.out.println(articleList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserManager userManager = new UserManager();
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
					userManager.addData(userOngoing);
				}else {
					userOngoing = userManager.selectByPseudoMdp(request.getParameter("pseudo"), request.getParameter("password"));
					
					if (request.getParameter("session") != null) {
						// création d'une session
						HttpSession session = request.getSession();
						// enregistrement du pseudo et du password dans le contexte de session
						session.setAttribute("pseudo", request.getParameter("pseudo"));
						session.setAttribute("password", request.getParameter("password"));
					}
				}
				
				request.setAttribute("user", userOngoing);
				System.out.println("UserConnected");
			} else {
				request.setAttribute("user", null);
				System.out.println("UserDisconnected");
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
