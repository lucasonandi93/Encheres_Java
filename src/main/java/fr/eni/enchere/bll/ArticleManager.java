/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.exceptions.BusinessException;

/**
* Classe en charge de 
* @author ldupont2022
* @date 9 janv. 2023 - 15:59:46
* @version ENI_Encheres - v0.1
*/
public class ArticleManager implements Manager<Article, Integer>{

	@Override
	public void addData(Article data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(Article data) throws BusinessException {
		// TODO Auto-generated method stub
		
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

}
