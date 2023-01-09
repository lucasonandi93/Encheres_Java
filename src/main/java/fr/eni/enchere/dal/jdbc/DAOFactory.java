/**
 * 
 */
package fr.eni.enchere.dal.jdbc;

/**
 * Classe en charge de créer une factory pour la DAO
 * @author slamire2022
 * @date 9 janv. 2023 - 14:38:30
 * @version ENI_Encheres - v0.1
 */
public class DAOFactory {
	public static ListeEnchereDAO getListeEnchereDAO() {
		return new ListeEnchereDAOJdbcImpl();
	}
}
