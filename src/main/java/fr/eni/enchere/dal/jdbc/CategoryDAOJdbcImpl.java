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
import fr.eni.enchere.dal.CategoryDAO;
import fr.eni.enchere.dal.CodesResultatDAL;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de communiquer avec la BDD et la Table CATEGORIES
 * 
 * @author slamire2022
 * @date 11 janv. 2023 - 09:22:04
 * @version ENI_Encheres - v0.1
 */
public class CategoryDAOJdbcImpl implements CategoryDAO {

	private static final String SQL_SELECT_ALL = "SELECT no_categorie, libelle FROM CATEGORIES";

	private static final String SQL_SELECT_BY_LIBELLE = "SELECT no_categorie, libelle FROM CATEGORIES WHERE libelle = ?";

	private static final String SQL_SELECT_BY_ID = "SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie = ?";
	/**
	 * Constructeur
	 */
	public CategoryDAOJdbcImpl() {
	}

	@Override
	public List<Category> selectAll() throws BusinessException {
		List<Category> listCategories = new ArrayList<>();
		PreparedStatement pstmt = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Category categoryOnGoing = new Category();
				if (rs.getInt("no_categorie") != categoryOnGoing.getNoCategory()) {
					categoryOnGoing = new Category(rs.getInt("no_categorie"), rs.getString("libelle"));
					listCategories.add(categoryOnGoing);
				}
			}
			rs.close();
			pstmt.close();
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.SELECT_LIST_CATEGORY_FAILED);
			throw businessException;
		}
		return listCategories;
	}

	@Override
	public Category selectByName(String libelle) throws BusinessException {
		
		Category categoryOngoing = new Category();
		// Déclaration d'un Prepared Statement et initialisation à null
		PreparedStatement pstmt = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// Passage de la requête au Prepared Statement
			pstmt = cnx.prepareStatement(SQL_SELECT_BY_LIBELLE);
			// Setter le paramètre de la requète SQL
			pstmt.setString(1, libelle);
			// Récupération des informations dans un ResultSet
			ResultSet rs = pstmt.executeQuery();
			// Boucler tant qu'il y a une ligne suivante
			if (rs.next()) {
				// Sécurité
				if (rs.getInt("no_categorie") != categoryOngoing.getNoCategory()) {
					
					categoryOngoing = new Category(rs.getInt("no_categorie"), rs.getString("libelle"));
				}
			}
			// Fermer le ResultSet
			rs.close();
			// Fermer le Statement
			pstmt.close();
			// Fermer la connection
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
			// Déclarer une BusinessException
			BusinessException businessException = new BusinessException();
			// Si il y a une erreur, ajouter l'erreur à la BusinessException
			businessException.addError(CodesResultatDAL.SELECT_ARTICLE_ID_FAILED);
			// Envoyer l'exception
			throw businessException;
		}
		return categoryOngoing;
	}

	@Override
	public Category selectById(Integer id) throws BusinessException {
		//Vérification si le paramêtre est valide
				if(id==null || id==0) {
					BusinessException businessException = new BusinessException();
					businessException.addError(CodesResultatDAL.INSERT_ID_ARTICLE_NULL);
					throw businessException;
				}
				
				Category categoryOnGoing = null;
				
				try (Connection cnx=ConnectionProvider.getConnection())
				{
					PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
					pstmt.setInt(1, id);
					ResultSet rs= pstmt.executeQuery();
					if (rs.next()) {
						categoryOnGoing = new Category(rs.getInt("no_categorie"), rs.getString("libelle"));
					}
					rs.close();
					pstmt.close();
					cnx.close();
				}catch(Exception e) {
					e.printStackTrace();
					BusinessException businessException = new BusinessException();
					businessException.addError(CodesResultatDAL.SELECT_CATEGORY_ID_FAILED);
					throw businessException;
				} 
				return categoryOnGoing;
	}

}
