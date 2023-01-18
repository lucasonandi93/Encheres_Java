package fr.eni.enchere.servlet;

import java.io.IOException;

import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForgetPassword
 */
@WebServlet("/ServletForgetPassword")
public class ServletForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletForgetPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/forgetPassword.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		UserManager userManager = new UserManager();
		User user = userManager.getUserByEmail(email);
		if (user != null) {
			String mdp = user.getPassword();
			if (Email.send(
					"enisitedenchere35@gmail.com", 
					"lqmzxvgumnmcnccd", 
					request.getParameter("email"),
					"Voici ton mot de passe", 
					"Mot de passe : " + user.getPassword()
					)) 
			{
				response.sendRedirect(request.getContextPath() + "/ServletConnexionPage");
			} else {
				request.setAttribute("error", "Erreur lors de l'envoi de l'email!!!");
				doGet(request, response);
			}

		}
	}
}