package fr.eni.enchere.dal.jdbc;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de 
 * @author slamire2022
 * @date 9 janv. 2023 - 15:21:09
 * @version ENI_Encheres - v0.1
 */
public interface ArticleDAO extends DAO<Article, Integer>{
	
	//insérer article dans table Retrait
	public void insertToWithdrawal (Article data) throws BusinessException;
	
	// sélectionner article par numéro de catégorie
	public void selectByNoCategory (Article data) throws BusinessException;
	
	// sélectionner article selon caractère contenu dans son nom
	public void selectByCharName (Article data) throws BusinessException;
	
}
