package fr.eni.enchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Servlet implementation class ServletDeleteProfile
 */
 @WebServlet("/deleteProfile")
public class ServletDeleteProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ServletDeleteProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<String> errors = new ArrayList<>();
	        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/updateProfil");
	        UserManager um = new UserManager();
	        User userToDelete = um.getUserByPseudo(request.getUserPrincipal().getName());
			um.deleteUser(userToDelete);
	        if (errors.isEmpty()) {
	            request.setAttribute("loginDeleted", "true");
	            request.setAttribute("page", "home");
	        } else {
	            request.setAttribute("page", "updateProfile");
	        }
	        SessionManagement.destroySession(request);
	        rd.forward(request, response);
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
