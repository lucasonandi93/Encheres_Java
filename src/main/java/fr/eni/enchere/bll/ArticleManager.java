/**
 * 
 */
package fr.eni.enchere.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.jdbc.ArticleDAO;
import fr.eni.enchere.dal.jdbc.DAOFactory;
import fr.eni.enchere.exceptions.BusinessException;

/**
* Classe en charge de 
* @author ldupont2022
* @date 9 janv. 2023 - 15:59:46
* @version ENI_Encheres - v0.1
*/
public class ArticleManager implements Manager<Article, Integer>{
	
	private ArticleDAO articleDAO;
	
	/**
	 * Constructeur
	 */
	public ArticleManager() {
		//Générer une instcane de ArticleDAO
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	/**
	 * Méthode qui permet d'ajouter un Article à la BDD
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void addData(Article data) throws BusinessException {
		//Déclarer et instancier une BusinessException
		BusinessException businessException = new BusinessException();
		//Vérifier si l'article est valide et peut être insérer dans la BDD
		this.validateData(data, businessException);
		//Si la BusinessException ne contient pas d'erreurs
		if (!businessException.hasErrors()) {
			//Appelle la méthode insert de ArticleDAO et lui passer l'Article en paramètre
			this.articleDAO.insert(data);
		}else {
			//Sinon remonter les erreurs
			throw businessException;
		}
	}

	/**
	 * Méthode qui permet de supprimer un Article de la BDD
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void deleteData(Integer id) throws BusinessException {
		//Appelle la méthode delete de ArticleDAO et lui passer un ID en paramètre
		this.articleDAO.delete(id);
	}

	/**
	 * Méthode qui permet de modifier un Article de la BDD
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void updateData(Article data) throws BusinessException {
		//Déclarer et instancier une BusinessException
		BusinessException businessException = new BusinessException();
		//Vérifier si l'article est valide et peut être modifier dans la BDD
		this.validateData(data, businessException);
		//Si la BusinessException ne contient pas d'erreurs
		if (!businessException.hasErrors()) {
			//Appelle la méthode update de ArticleDAO et lui passer l'Article en paramètre
			this.articleDAO.update(data);
		}else {
			//Sinon remonter les erreurs
			throw businessException;
		}
	}

	/**
	 * Méthode qui permet de sélectionner tous les lignes de la table Article
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List<Article> selectAll() throws BusinessException {
		//Appelle la méthode selectAll de ArticleDAO
		return this.articleDAO.selectAll();
	}
	
	/**
	 * Méthode qui permet de sélectionner les article d'une categorie
	 * @param noCategory
	 * @return
	 * @throws BusinessException
	 */
	public List<Article> selectByNoCategory(Integer noCategory) throws BusinessException{
		//Appelle la méthode selectByNoCategory de ArticleDAO
		return this.articleDAO.selectByNoCategory(noCategory);
	}
	
	/**
	 * Méthode qui permet de sélectionner les article dont le nom comporte une chaine de caractère spécifique
	 * @param contents
	 * @return
	 * @throws BusinessException
	 */
	public List<Article> selectByName(String contents) throws BusinessException{
		//Appelle la méthode selectByCharName de ArticleDAO
		return this.articleDAO.selectByCharName(contents);
	}
	
	/**
	 * Méthode qui permet de sélectionner les article d'une categorie dont le nom comporte une chaine de caractère spécifique
	 * @param noCategory
	 * @param contents
	 * @return
	 * @throws BusinessException
	 */
	public List<Article> selectByNoCategoryAndName(Integer noCategory, String contents) throws BusinessException{
		//Appelle la méthode selectByNoCategoryAndCharName de ArticleDAO
		return this.articleDAO.selectByNoCategoryAndCharName(noCategory, contents);
	}

	/**
	 * Méthode qui permet de sélectionner un Article avec son ID
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Article selectById(Integer id) throws BusinessException {
		//Appelle la méthode selectById de ArticleDAO  et lui passer un ID en paramètre
		return this.articleDAO.selectById(id);
	}

	/**
	 * Méthode qui permet vérifier qu'un Article peut être inséré ou modifié 
	 * @param data
	 * @throws BusinessException
	 */
	@Override
	public void validateData(Article data, BusinessException businessException) throws BusinessException {
		
		//Vérification que le nom de l'article est valide
		if(data.getNameArticle()==null || data.getNameArticle().equalsIgnoreCase("") || data.getNameArticle().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_NAME_ERROR);
		}
		
		//Vérification que la description de l'article est valide
		if(data.getDescription()==null || data.getDescription().equalsIgnoreCase("") || data.getDescription().length() > 300) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_DECRIPTION_ERROR);
		}
		
		//Vérification que la date de début d'enchère de l'article est valide
		if (data.getAuctionStartDate().isBefore(LocalDate.now()) || data.getAuctionStartDate()==null) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_START_DATE_ERROR);
		}
		
		//Vérification que la date de fin d'enchère de l'article est valide
		if (data.getAuctionEndDate().isBefore(data.getAuctionStartDate()) || data.getAuctionEndDate()==null) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_END_DATE_ERROR);
		}
		
		//Vérification que le numéro d'utilisateur est valide (VENDEUR)
		if (data.getUser()==null) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_USER_ERROR);
		}
		
		//Vérification que le numéro de catégorie de l'article est valide
		if (data.getCategory() == null) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_CATEGORY_ERROR);
		}
		
		//Vérification que le nom de rue du lieu de retrait de l'article est valide
		if (data.getWithdrawal().getStreet()==null || data.getWithdrawal().getStreet().equalsIgnoreCase("") || data.getWithdrawal().getStreet().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_WITHDRAWAL_ERROR);
		}
		
		//Vérification que le code postal du lieu de retrait de l'article est valide
		if (data.getWithdrawal().getCp()==null || data.getWithdrawal().getCp().equalsIgnoreCase("") || data.getWithdrawal().getCp().length() > 10) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_WITHDRAWAL_ERROR);
		}
		
		//Vérification que la ville du lieu de retrait de l'article est valide
		if (data.getWithdrawal().getCity()==null || data.getWithdrawal().getCity().equalsIgnoreCase("") || data.getWithdrawal().getCity().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_WITHDRAWAL_ERROR);
		}
	}
}
