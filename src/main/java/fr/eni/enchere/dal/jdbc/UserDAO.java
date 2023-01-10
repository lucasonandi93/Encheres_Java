package fr.eni.enchere.dal.jdbc;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de 
 * @author slamire2022
 * @date 9 janv. 2023 - 15:20:58
 * @version ENI_Encheres - v0.1
 */
public interface UserDAO extends DAO<User, Integer>{
	
	public  User selectByPseudoMdp(String pseudo, String mdp) throws BusinessException;
	
}
