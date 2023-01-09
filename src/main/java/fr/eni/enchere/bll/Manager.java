/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.exceptions.BusinessException;

/**
* Classe en charge de 
* @author ldupont2022
* @date 9 janv. 2023 - 15:46:58
* @version ENI_Encheres - v0.1
* @param <T>
* @param <U>
*/
public interface Manager <T, U>{
	
	/**
	 * Méthode qui permet d'ajouter des données à la BDD
	 * @param data
	 * @throws BusinessException
	 */
	public void addData(T data) throws BusinessException;
	
	/**
	 * Méthode qui permet de supprimer des données de la BDD
	 * @param id
	 * @throws BusinessException
	 */
	public void deleteData(U id) throws BusinessException;
	
	/**
	 * Méthode qui permet de modifier des données de la BDD
	 * @param data
	 * @throws BusinessException
	 */
	public void updateData(T data) throws BusinessException;
	
	/**
	 * Méthode qui permet de sélectionner tous les datas d'une table
	 * @return
	 * @throws BusinessException
	 */
	public List<T> selectAll() throws BusinessException;
	
	/**
	 * Méthode qui permet de sélectionner une data avec son ID
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public T selectById(U id) throws BusinessException;
	
}
