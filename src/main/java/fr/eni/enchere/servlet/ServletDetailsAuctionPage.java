package fr.eni.enchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Servlet implementation class ServletConnexionPage
 */
@WebServlet("/ServletDetailsAuctionPage")
public class ServletDetailsAuctionPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetailsAuctionPage() throws ServletException {
        super();
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleManager articleManager = new ArticleManager();
		
		try {
			Article articleOngoing = articleManager.selectById(Integer.parseInt(request.getParameter("articleID")));
			request.setAttribute("articleOngoing", articleOngoing);
			
		} catch (NumberFormatException | BusinessException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailsAuctionPage.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Auction auctionOngoing = new Auction();
		Article articleOngoing = new Article();
		User userOngoing = new User();
		
			
		
		// si proposition d'enchère
		if (request.getParameter("auction") != null && Integer.parseInt(request.getParameter("auction")) !=0) {
			
			// vérifier qu'elle soit supérieure à l'enchère en cours
			if(Integer.parseInt(request.getParameter("auction")) > articleOngoing.getSellingPrice()) {
				// récupérer montant de ma proposition après clic sur "enchérir"
				auctionOngoing.setAuctionAmount(Integer.parseInt(request.getParameter("auction")));
				auctionOngoing.setArticle(0);
				auctionOngoing.setUser(0);
				
				// si oui, remplacer valeur enchère en cours par ma proposition dans "meilleure offre"
				articleOngoing.setSellingPrice(auctionOngoing.getAuctionAmount());
				// et récupérer le nom de l'utilisateur qui l'a faite
				HttpSession session = request.getSession();
				userOngoing.setName(((User)session.getAttribute("user")).getName());
				
			}else {
				// sinon, afficher valeur de l'enchère en cours dans "meilleure offre"
				
				
			}
		}
		doGet(request, response);
	}
}
