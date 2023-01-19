/**
 * 
 */
package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Category;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Interface en charge de transmettre les méthodes spécifiques à la classe CategoryDAOJdbcImpl
 * @author slamire2022
 * @date 11 janv. 2023 - 09:20:14
 * @version ENI_Encheres - v0.1
 */
public interface CategoryDAO {
	/**
	 * Méthode qui permet de sélectionner l'ensemble des lignes d'une table de la BDD
	 * @return
	 * @throws BusinessException
	 */
	public List<Category> selectAll() throws BusinessException;
	
	public Category selectByName(String libelle) throws BusinessException;

	/**
	 * Méthode qui permet
	 * @param int1
	 * @return
	 */
	public Category selectById(Integer id) throws BusinessException;
}
