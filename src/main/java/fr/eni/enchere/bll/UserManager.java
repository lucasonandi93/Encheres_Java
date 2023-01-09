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
		BusinessException businessException = new BusinessException();
		this.validateData(data, businessException);
		if (!businessException.hasErrors()) {
			this.userDAO.insert(data);
		}else {
			throw businessException;
		}
		
	}

	@Override
	public void deleteData(Integer id) throws BusinessException {
		this.userDAO.delete(id);
	}

	@Override
	public void updateData(User data) throws BusinessException {
		BusinessException businessException = new BusinessException();
		this.validateData(data, businessException);
		if (!businessException.hasErrors()) {
			this.userDAO.update(data);
		}else {
			throw businessException;
		}
	}

	@Override
	public List<User> selectAll() throws BusinessException {
		return this.userDAO.selectAll();
	}

	@Override
	public User selectById(Integer id) throws BusinessException {
		return this.userDAO.selectById(id);
	}

	@Override
	public void validateData(User data, BusinessException businessException) throws BusinessException {
		if(data.getPseudo()==null || data.getPseudo().equalsIgnoreCase("") || data.getPseudo().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_USER_PSEUDO_ERROR);
		}
		
		if (data.getName()==null || data.getName().equalsIgnoreCase("") || data.getName().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_USER_NAME_ERROR);
		}
		
		if (data.getFirstName()==null || data.getFirstName().equalsIgnoreCase("") || data.getFirstName().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_USER_FIRSTNAME_ERROR);
		}
		
		if (data.getEmail()==null || data.getEmail().equalsIgnoreCase("") || data.getEmail().length() > 50) {
			businessException.addError(CodesResultatBLL.RULE_USER_EMAIL_ERROR);
		}
		
		if (data.getStreet()==null || data.getStreet().equalsIgnoreCase("") || data.getStreet().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_USER_STREET_ERROR);
		}
		
		if (data.getCp()==null || data.getCp().equalsIgnoreCase("") || data.getCp().length() > 10) {
			businessException.addError(CodesResultatBLL.RULE_USER_CP_ERROR);
		}
		
		if (data.getCity()==null || data.getCity().equalsIgnoreCase("") || data.getCity().length() > 50) {
			businessException.addError(CodesResultatBLL.RULE_USER_CITY_ERROR);
		}
		
		if (data.getPassword()==null || data.getPassword().equalsIgnoreCase("") || data.getPassword().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_USER_PASSWORD_ERROR);
		}
	}
	

}
