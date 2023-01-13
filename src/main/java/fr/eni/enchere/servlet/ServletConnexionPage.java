package fr.eni.enchere.servlet;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		
		
//		if (session.getAttribute("pseudo") != null || session.getAttribute("pseudo") != "" && session.getAttribute("password") != null || session.getAttribute("password") != "" ) {
//			request.setAttribute("pseudo", session.getAttribute("pseudo"));
//			request.setAttribute("password", session.getAttribute("password"));
//		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/connexionPage.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
