package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.exceptions.BusinessException;


/**
* Interface en charge de transmettre les méthodes CRUD
* @author lucasonandi93
* @date 10 janv. 2023 - 14:15:01
* @version ENI_Encheres - v0.1
* @param <T>
* @param <U>
*/
public interface DAO <T, U> {

	/**
	 * Méthode qui permet de sélectionner l'ensemble des lignes d'une table de la BDD
	 * @return
	 * @throws BusinessException
	 */
	public List<T> selectAll() throws BusinessException;
	
	/**
	 * Méthode qui permet de sélectionner une donné dans une table de la BDD avec son ID
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public T selectById(U id) throws BusinessException;
	
	/**
	 * Méthode qui permet d'insérer une donné dans une table de la BDD
	 * @param data
	 * @throws BusinessException
	 */
	public void insert(T data) throws BusinessException;
	
	/**
	 * Méthode qui permet de modifier une donné dans une table de la BDD
	 * @param data
	 * @throws BusinessException
	 */
	public void update(T data) throws BusinessException;
	
	/**
	 * Méthode qui permet de supprimer une donné dans une table de la BDD
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(U id) throws BusinessException;
	
}
