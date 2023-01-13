package fr.eni.enchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.jdbc.DAOFactory;
import fr.eni.enchere.dal.jdbc.UserDAO;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Servlet implementation class ServletProfilPage
 */
@WebServlet("/ServletProfilPage")
public class ServletProfilPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfilPage() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			UserManager userManager= new UserManager();
			
			String pseudoProfil = request.getParameter("userProfil");
			
			User userProfil = userManager.selectByPseudo(pseudoProfil);
		
			request.setAttribute("userProfil", userProfil);
		
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profilPage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
