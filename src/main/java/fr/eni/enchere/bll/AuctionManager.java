/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.dal.jdbc.AuctionDAO;
import fr.eni.enchere.dal.jdbc.DAOFactory;
import fr.eni.enchere.exceptions.BusinessException;
import jakarta.servlet.http.HttpServletRequest;

/**
* Classe en charge de 
* @author ldupont2022
* @date 9 janv. 2023 - 15:57:21
* @version ENI_Encheres - v0.1
*/
public class AuctionManager implements Manager<Auction, Integer>{

	private AuctionDAO auctionDAO;
	
	/**
	 * Constructeur
	 */
	public AuctionManager() {
		this.auctionDAO = DAOFactory.getAuctionDAO();
	}
	
	/**
	 * Méthode qui permet d'ajouter une enchère à la BDD
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void addData(Auction data) throws BusinessException {
		//Déclarer et instancier une BusinessException
		BusinessException businessException = new BusinessException();
		//Vérifier si l'enchère est valide et peut être insérer dans la BDD
		this.validateData(data, businessException);
		//Si la BusinessException ne contient pas d'erreurs
		if (!businessException.hasErrors()) {
			//Appelle la méthode insert de AuctionDAO et lui passer l'Auction en paramètre
			this.auctionDAO.insert(data);
		}else {
			//Sinon remonter les erreurs
			throw businessException;
		}
	}

	/**
	 * Méthode qui permet de supprimer une Auction de la BDD
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void deleteData(Integer id) throws BusinessException {
		//Appelle la méthode delete de AuctionDAO et lui passer un ID en paramètre
		this.auctionDAO.delete(id);
	}

	/**
	 * Méthode qui permet de modifier un Auction de la BDD
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void updateData(Auction data) throws BusinessException {
		//Déclarer et instancier une BusinessException
		BusinessException businessException = new BusinessException();
		//Vérifier si l'enchère est valide et peut être insérer dans la BDD
		this.validateData(data, businessException);
		//Si la BusinessException ne contient pas d'erreurs
		if (!businessException.hasErrors()) {
			//Appelle la méthode update de AuctionDAO et lui passer l'Auction en paramètre
			this.auctionDAO.update(data);
		}else {
			//Sinon remonter les erreurs
			throw businessException;
		}
		
	}

	/**
	 * Méthode qui permet de sélectionner tous les lignes de la table Auction
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List<Auction> selectAll() throws BusinessException {
		//Appelle la méthode selectAll de AuctionDAO
		return this.auctionDAO.selectAll();
	}

	/**
	 * Méthode qui permet de sélectionner une Auction avec son ID
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Auction selectById(Integer id) throws BusinessException {
		//Appelle la méthode selectById de AuctionDAO et lui passer un ID en paramètre
		return this.auctionDAO.selectById(id);
	}

	/**
	 * Méthode qui permet vérifier qu'une Auction peut être inséré ou modifié 
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void validateData(Auction data, BusinessException businessException) throws BusinessException {
		
		//Déclaration et instanciation d'un ArticleManager
		ArticleManager articleManager = new ArticleManager();
		
		//Vérification que le numéro d'utilisateur est valide (ACHETEUR)
		if (data.getUser()==null) {
			businessException.addError(CodesResultatBLL.RULE_AUCTION_NO_USER_ERROR);
		}
		
		//Vérification que le numéro d'article est valide
		if (data.getArticle()==null) {
			businessException.addError(CodesResultatBLL.RULE_AUCTION_NO_ARTICLE_ERROR);
		}
		
		//Vérification que le montant proposé est supérieur au montant de l'enchère précédente
		for (Auction auction : articleManager.selectById(data.getArticle().getNoArticle()).getListAuction()) {
			if (auction.getAuctionAmount() >= data.getAuctionAmount()) {
				businessException.addError(CodesResultatBLL.RULE_AUCTION_AMOUNT_ERROR);
				break;
			}
		}
	}

	/**
	 * Méthode qui permet de sélectionner tous les lignes de la table Auction selon ID Article
	 * @param noArticle
	 * @return
	 * @throws BusinessException
	 */
	public List<Auction> selectByNoArticle(Integer noArticle) throws BusinessException {
		//Appelle la méthode selectByNoArticle de AuctionDAO
		return this.auctionDAO.selectByNoArticle(noArticle);
	}
	
	public List<Auction> selectByNoUser(Integer noUser) throws BusinessException {
		//Appelle la méthode selectByNoArticle de AuctionDAO
		return this.auctionDAO.selectByNoUser(noUser);
	}

	@Override
	public void updateData(Article data, HttpServletRequest request) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Integer id, HttpServletRequest request) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
}
