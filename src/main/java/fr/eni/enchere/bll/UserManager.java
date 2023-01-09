/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.jdbc.DAOFactory;
import fr.eni.enchere.dal.jdbc.UserDAO;
import fr.eni.enchere.exceptions.BusinessException;

/**
* Classe en charge de 
* @author ldupont2022
* @date 9 janv. 2023 - 15:52:52
* @version ENI_Encheres - v0.1
*/
public class UserManager implements Manager<User, Integer>{

	private UserDAO userDAO;
	
	/**
	 * Constructeur
	 */
	public UserManager() {
		this.userDAO = DAOFactory.getUserDAO();
	}
	
	@Override
	public void addData(User data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Integer id) throws BusinessException {
		this.userDAO.delete(id);
	}

	@Override
	public void updateData(User data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> selectAll() throws BusinessException {
		return this.userDAO.selectAll();
	}

	@Override
	public User selectById(Integer id) throws BusinessException {
		return this.userDAO.selectById(id);
	}

}
