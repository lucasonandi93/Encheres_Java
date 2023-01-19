package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Interface en charge de transmettre les méthodes spécifiques à la classe ArticleDAOJdbcImpl
 * @author slamire2022
 * @date 9 janv. 2023 - 15:21:09
 * @version ENI_Encheres - v0.1
 */
public interface ArticleDAO extends DAO<Article, Integer>{
	
	//insérer article dans table Retrait
	public void insertToWithdrawal (Article data) throws BusinessException;
	
	// sélectionner article par numéro de catégorie
	public List<Article> selectByNoCategory (Integer noCategory) throws BusinessException;
	
	// sélectionner article selon caractère contenu dans son nom
	public List<Article> selectByCharName (String contents) throws BusinessException;
	
	public List<Article> selectByNoCategoryAndCharName (Integer noCategory, String contents) throws BusinessException;
	
}
