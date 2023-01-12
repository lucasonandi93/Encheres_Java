/**
 * 
 */
package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Category;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge  de communiquer avec la BDD et la Table CATEGORIES
 * @author slamire2022
 * @date 11 janv. 2023 - 09:22:04
 * @version ENI_Encheres - v0.1
 */
public class CategoryDAOJdbcImpl implements CategoryDAO {

	private static final String SQL_SELECT_ALL = "SELECT no_categorie, libelle FROM CATEGORIES";
	
	/**
	 * Constructeur
	 */
	public CategoryDAOJdbcImpl() {
	}

	@Override
	public List<Category> selectAll() throws BusinessException {
		List<Category> listCategories = new ArrayList<>();
		PreparedStatement pstmt = null;
		
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Category categoryOnGoing = new Category();
				if(rs.getInt("no_categorie")!= categoryOnGoing.getNoCategory()) {
					categoryOnGoing = new Category(rs.getInt("no_categorie"), rs.getString("libelle"));
					listCategories.add(categoryOnGoing);
				}
			}
			rs.close();
			pstmt.close();
			cnx.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.SELECT_LIST_CATEGORY_FAILED);
			throw businessException;
		}
		return listCategories;
	}

}
