package fr.eni.enchere.servlet;

import java.io.IOException;

import java.util.List;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.CategoryManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet(name="ServletListOfAuctionsPage",
			urlPatterns="/ServletListOfAuctionsPage",
			initParams={
					@WebInitParam( name="UserID", 
							value="")
			})
public class ServletListOfAuctionsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListOfAuctionsPage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager articleManager = new ArticleManager();
		CategoryManager categoryManager = new CategoryManager();
		List<Article> articleList= null;
		List<Category> categoryList= null;
		
		try {
			
			User userOngoing = (User) request.getAttribute("user");
			
			
			categoryList = categoryManager.selectAll();
			request.setAttribute("categoryList", categoryList);
			
			Category categoryOngoing = categoryManager.selectByName(request.getParameter("categories"));
			
			if (request.getParameter("content")==null || (request.getParameter("content")=="" && request.getParameter("categories")=="Toutes")) {
				articleList = articleManager.selectAll();
				request.setAttribute("articleList", articleList);
			}else if(request.getParameter("content")==null || (request.getParameter("content")=="" && request.getParameter("categories")!="Toutes")) {
				articleList = articleManager.selectByNoCategory(categoryOngoing.getNoCategory());
				request.setAttribute("articleList", articleList);
			}else if(request.getParameter("content")!=null || (request.getParameter("content")!="" && request.getParameter("categories")=="Toutes")){
				articleList = articleManager.selectByName(request.getParameter("content"));
				request.setAttribute("articleList", articleList);
			}else if(request.getParameter("content")!=null || (request.getParameter("content")!="" && request.getParameter("categories")!="Toutes")) {
				articleList = articleManager.selectByNoCategoryAndName(categoryOngoing.getNoCategory(), request.getParameter("content"));
				request.setAttribute("articleList", articleList);
			}else {
				articleList = null;
			}
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/listOfAuctionsPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}

}
