/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.Date;
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
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	@Override
	public void addData(Article data) throws BusinessException {
		
		BusinessException businessException = new BusinessException();
		this.validateData(data, businessException);
		if (!businessException.hasErrors()) {
			this.articleDAO.insert(data);
		}else {
			throw businessException;
		}
	}

	@Override
	public void deleteData(Integer id) throws BusinessException {
		this.articleDAO.delete(id);
	}

	@Override
	public void updateData(Article data) throws BusinessException {
		BusinessException businessException = new BusinessException();
		this.validateData(data, businessException);
		if (!businessException.hasErrors()) {
			this.articleDAO.update(data);
		}else {
			throw businessException;
		}
	}

	@Override
	public List<Article> selectAll() throws BusinessException {
		return this.articleDAO.selectAll();
	}

	@Override
	public Article selectById(Integer id) throws BusinessException {
		return this.articleDAO.selectById(id);
	}

	@Override
	public void validateData(Article data, BusinessException businessException) throws BusinessException {
		
		if(data.getNameArticle()==null || data.getNameArticle().equalsIgnoreCase("") || data.getNameArticle().length() > 30) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_NAME_ERROR);
		}
		
		if(data.getDescription()==null || data.getDescription().equalsIgnoreCase("") || data.getDescription().length() > 300) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_DECRIPTION_ERROR);
		}
		
		if (data.getAuctionStartDate().before(new Date()) || data.getAuctionStartDate()==null) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_START_DATE_ERROR);
		}
		
		if (data.getAuctionEndDate().before(data.getAuctionStartDate()) || data.getAuctionEndDate()==null) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_END_DATE_ERROR);
		}
		
		if (data.getNoUser()==0) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_NO_USER_ERROR);
		}
		
		if (data.getNoCategory()==0) {
			businessException.addError(CodesResultatBLL.RULE_ARTICLE_NO_CATEGORY_ERROR);
		}
	}

	

}
