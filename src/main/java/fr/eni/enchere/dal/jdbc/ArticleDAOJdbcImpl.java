
package fr.eni.enchere.dal.jdbc;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de de définir les requêtes sql pour l'objet article
 * @author slamire2022
 * @date 9 janv. 2023 - 15:32:53
 * @version ENI_Encheres - v0.1
 */
public class ArticleDAOJdbcImpl implements ArticleDAO {

	/**
	 * Constructeur
	 */
	public ArticleDAOJdbcImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Article> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article selectById(Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Article data) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Article data) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws BusinessException {
		// TODO Auto-generated method stub

	}

}
