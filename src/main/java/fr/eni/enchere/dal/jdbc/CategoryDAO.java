/**
 * 
 */
package fr.eni.enchere.dal.jdbc;

import java.util.List;

import fr.eni.enchere.exceptions.BusinessException;

/**
 * Interface en charge de transmettre les méthodes spécifiques à la classe CategoryDAOJdbcImpl
 * @author slamire2022
 * @date 11 janv. 2023 - 09:20:14
 * @version ENI_Encheres - v0.1
 */
public interface CategoryDAO <T, t> {
	/**
	 * Méthode qui permet de sélectionner l'ensemble des lignes d'une table de la BDD
	 * @return
	 * @throws BusinessException
	 */
	public List<T> selectAll() throws BusinessException;
}
