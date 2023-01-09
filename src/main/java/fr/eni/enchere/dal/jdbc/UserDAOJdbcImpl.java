/**
 * 
 */
package fr.eni.enchere.dal.jdbc;

import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de 
 * @author slamire2022
 * @date 9 janv. 2023 - 15:32:30
 * @version ENI_Encheres - v0.1
 */
public class UserDAOJdbcImpl implements UserDAO {

	/**
	 * Constructeur
	 */
	public UserDAOJdbcImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectById(Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(User data) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User data) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws BusinessException {
		// TODO Auto-generated method stub

	}

}
