package fr.eni.enchere.servlet;

import java.io.IOException;

import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConnexionPage
 */
@WebServlet("/ServletConnexionPage")
public class ServletConnexionPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexionPage() throws ServletException {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserManager userManager = new UserManager();
		User userOngoing = new User();
		
		// récup cookies possible seulement sous forme de tableau
		Cookie[] cookies = request.getCookies();
		        if (cookies != null) {
		            for (Cookie cookie : cookies) {
		                // viser le cookie recherché
		                if (cookie.getName().equals("pseudo")) {
		                    // récup de la valeur du cookie
		                    userOngoing.setPseudo(cookie.getValue());
		                }
		                if (cookie.getName().equals("password")) {
		                    // récup de la valeur du cookie
		                	userOngoing.setPassword(cookie.getValue());
		                	try {
								userOngoing = userManager.selectByPseudoMdp(userOngoing.getPseudo(), userOngoing.getPassword());
							} catch (BusinessException e) {
								e.printStackTrace();
							}
		                }
		            }
		           
		            request.setAttribute("userSaved", userOngoing);
		        }
		
		request.getRequestDispatcher("/WEB-INF/jsp/connexionPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}