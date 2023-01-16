package fr.eni.enchere.servlet;

import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionManagement {
    /**
     * Get the session and record a session attribute for 5 minutes
     * @param request The request instance
     */
    public static void setSessionConnected (HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(300);
        session.setAttribute("isConnected", "true");
    }

    /**
     * Destroy the session, bye bye user !
     * @param request The request instance
     */
    public static void destroySession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }

    /**
     *Set a session JavaBean from the pseudo the connected user
     * @param request The request instance
     * @param pseudo_utilisateur String
     * @throws DALException If there were any SQL issue into the DAL
     */
    public static void setUtilisateurSessionBean(HttpServletRequest request, String pseudo_utilisateur) throws BusinessException {
        UserManager um = new UserManager();
        HttpSession session = request.getSession();
        User userToBean = um.getUserByPseudo(pseudo_utilisateur);
        session.setAttribute("utilisateurSession", userToBean);
    }
}