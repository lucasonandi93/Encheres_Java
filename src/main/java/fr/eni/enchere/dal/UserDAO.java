package fr.eni.enchere.dal;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Interface en charge de transmettre les méthodes spécifiques à la classe UserDAOJdbcImpl
 * @author slamire2022
 * @date 9 janv. 2023 - 15:20:58
 * @version ENI_Encheres - v0.1
 */
public interface UserDAO extends DAO<User, Integer>{
	
	/**
	 * Méthode qui permet sélectionner un utilisateur dans une table de la BDD avec son pseudo et son mdp
	 * @param pseudo
	 * @param mdp
	 * @return
	 * @throws BusinessException
	 */
	public User selectByPseudoMdp(String pseudo, String mdp) throws BusinessException;

	public User selectByEmail(String email) ;
	
}
