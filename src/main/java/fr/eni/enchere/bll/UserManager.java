/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UserDAO;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge d'appeler les méthodes d'UserDAO
 * @author lucasonandi93
 * @date 9 janv. 2023 - 15:52:52
 * @version ENI_Encheres - v0.1
 */
public class UserManager implements Manager<User, Integer> {

	private UserDAO userDAO;

	/**
	 * Constructeur
	 */
	public UserManager() {
		this.userDAO = DAOFactory.getUserDAO();
	}

	/**
	 * Méthode qui permet d'ajouter un User à la BDD
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void addData(User data) throws BusinessException {
		// Déclarer et instancier une BusinessException
		BusinessException businessException = new BusinessException();
		// Vérifier si le User est valide et peut être insérer dans la BDD
		this.validateData(data, businessException);
		// Si la BusinessException ne contient pas d'erreurs
		if (!businessException.hasErrors()) {
			// Appelle la méthode insert de UserDAO et lui passer l'Auction en paramètre
			this.userDAO.insert(data);
		} else {
			// Sinon remonter les erreurs
			throw businessException;
		}
	}

	/**
	 * Méthode qui permet de supprimer un User de la BDD
	 * @param id
	 * @throws BusinessException
	 */
	@Override
	public void deleteData(Integer id) throws BusinessException {
		// Appelle la méthode delete de UserDAO et lui passer un ID en paramètre
		this.userDAO.delete(id);
	}

	/**
	 * Méthode qui permet de modifier un User de la BDD
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void updateData(User data) throws BusinessException {
		// Déclarer et instancier une BusinessException
		BusinessException businessException = new BusinessException();
		// Vérifier si le User est valide et peut être insérer dans la BDD
		this.validateData(data, businessException);
		// Si la BusinessException ne contient pas d'erreurs
		if (!businessException.hasErrors()) {
			// Appelle la méthode update de UserDAO et lui passer le User en paramètre
			this.userDAO.update(data);
		} else {
			// Sinon remonter les erreurs
			throw businessException;
		}
	}

	/**
	 * Méthode qui permet de sélectionner tous les lignes de la table User
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List<User> selectAll() throws BusinessException {
		// Appelle la méthode selectAll de UserDAO
		return this.userDAO.selectAll();
	}

	/**
	 * Méthode qui permet de sélectionner un User avec son ID
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public User selectById(Integer id) throws BusinessException {
		// Appelle la méthode selectById de AuctionDAO et lui passer un ID en paramètre
		return this.userDAO.selectById(id);
	}

	public User selectByPseudoMdp(String pseudo, String mdp) throws BusinessException {
		// Appelle la méthode selectByPseudoMdp de AuctionDAO
		return this.userDAO.selectByPseudoMdp(pseudo, mdp);
	}

	/**
	 * Méthode qui permet vérifier qu'un User peut être inséré ou modifié
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void validateData(User data, BusinessException businessException) throws BusinessException {

		// Vérification que le pseudo de l'utilisateur est valide
		if (data.getPseudo() == null || data.getPseudo().equalsIgnoreCase("") || data.getPseudo().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_USER_PSEUDO_ERROR);
		}

		// Vérification que le nom de l'utilisateur est valide
		if (data.getName() == null || data.getName().equalsIgnoreCase("") || data.getName().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_USER_NAME_ERROR);
		}

		// Vérification que le prenom de l'utilisateur est valide
		if (data.getFirstName() == null || data.getFirstName().equalsIgnoreCase("")
				|| data.getFirstName().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_USER_FIRSTNAME_ERROR);
		}

		// Vérification que l'email de l'utilisateur est valide
		if (data.getEmail() == null || data.getEmail().equalsIgnoreCase("") || data.getEmail().length() > 50) {
			businessException.addError(CodesResultatBLL.RULE_USER_EMAIL_ERROR);
		}

		// Vérification que le téléphone de l'utilisateur est valide
		if (data.getPhone().length() > 15) {
			businessException.addError(CodesResultatBLL.RULE_USER_PHONE_ERROR);
		}

		// Vérification que la rue de l'utilisateur est valide
		if (data.getStreet() == null || data.getStreet().equalsIgnoreCase("") || data.getStreet().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_USER_STREET_ERROR);
		}

		// Vérification que le code postal de l'utilisateur est valide
		if (data.getCp() == null || data.getCp().equalsIgnoreCase("") || data.getCp().length() > 10) {
			businessException.addError(CodesResultatBLL.RULE_USER_CP_ERROR);
		}

		// Vérification que la ville de l'utilisateur est valide
		if (data.getCity() == null || data.getCity().equalsIgnoreCase("") || data.getCity().length() > 50) {
			businessException.addError(CodesResultatBLL.RULE_USER_CITY_ERROR);
		}

		// Vérification que le mot de passe de l'utilisateur est valide
		if (data.getPassword() == null || data.getPassword().equalsIgnoreCase("") || data.getPassword().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_USER_PASSWORD_ERROR);
		}
	}

	public User getUserByPseudo(String pseudo_utilisateur) {
		return this.getUserByPseudo(pseudo_utilisateur);
	}

	public void deleteUser(User userToDelete) {

	}

	public User getUserByEmail(String email) {
		return userDAO.selectByEmail(email);
	}
}