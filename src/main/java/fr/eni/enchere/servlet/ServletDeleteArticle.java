package fr.eni.enchere.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Servlet implementation class ServletDeleteArticle
 */
@WebServlet("/ServleteDeleteArticle")
public class ServletDeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDeleteArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("cancelSale") != null){
	        int idArticle = Integer.parseInt(request.getParameter("idArticle"));
	        ArticleManager articleManager = new ArticleManager();
	        try {
				articleManager.deleteData(idArticle);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        response.sendRedirect("ServletListOfAuctionsPage");
	    }
	}

}
