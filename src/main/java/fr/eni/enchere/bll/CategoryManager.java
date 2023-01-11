/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.dal.jdbc.CategoryDAO;
import fr.eni.enchere.dal.jdbc.DAOFactory;
import fr.eni.enchere.exceptions.BusinessException;

/**
* Classe en charge de 
* @author ldupont2022
* @date 11 janv. 2023 - 13:18:20
* @version trocenchere - v0.1
*/
public class CategoryManager {

	private CategoryDAO categoryDAO;
	
	/**
	 * Constructeur
	 */
	public CategoryManager() {
		categoryDAO = DAOFactory.getCategoryDAO();
	}
	
	/**
	 * Méthode qui permet de sélectionner tous les lignes de la table Category
	 * @return
	 * @throws BusinessException
	 */
	public List<Category> selectAll() throws BusinessException {
		//Appelle la méthode selectAll de CategoryDAO
		return this.categoryDAO.selectAll();
	}
	
}
