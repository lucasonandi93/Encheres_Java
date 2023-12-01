/**
 * 
 */
package fr.eni.enchere.dal;

import java.lang.reflect.InvocationTargetException;

import fr.eni.enchere.config.Settings;

/**
 * Classe en charge de créer une factory pour la DAO
 * @author lucasonandi93
 * @date 9 janv. 2023 - 14:38:30
 * @version ENI_Encheres - v0.1
 */
public class DAOFactory {
	
	
	public static UserDAO getUserDAO() {
		UserDAO userDAO = null;
		try {
			userDAO = (UserDAO) Class.forName(Settings.getProperty("userdaoimpl")).getDeclaredConstructor().newInstance();
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userDAO;
	}
	
	public static AuctionDAO getAuctionDAO() {
		AuctionDAO auctionDAO = null;
		try {
			auctionDAO = (AuctionDAO) Class.forName(Settings.getProperty("auctiondaoimpl")).getDeclaredConstructor().newInstance();
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return auctionDAO;
	}
	
	public static ArticleDAO getArticleDAO() {
		ArticleDAO articleDAO = null;
		try {
			articleDAO = (ArticleDAO) Class.forName(Settings.getProperty("articledaoimpl")).getDeclaredConstructor().newInstance();
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return articleDAO;
	}
	
	public static CategoryDAO getCategoryDAO() {
		CategoryDAO categoryDAO = null;
		try {
			categoryDAO = (CategoryDAO) Class.forName(Settings.getProperty("categorydaoimpl")).getDeclaredConstructor().newInstance();
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return categoryDAO;
	}
	
}
