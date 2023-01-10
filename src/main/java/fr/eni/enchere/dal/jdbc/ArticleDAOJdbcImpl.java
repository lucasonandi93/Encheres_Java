
package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de de définir les requêtes sql pour l'objet article(no_utilisateur = VENDEUR)
 * @author slamire2022
 * @date 9 janv. 2023 - 15:32:53
 * @version ENI_Encheres - v0.1
 */
public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String SQL_SELECT_ALL = 			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres,"
															+ "prix_initial, prix_vente, no_utilisateur, no_categorie, rue, code_postal, ville "
															+ "FROM ARTICLES_VENDUS a "
															+ "INNER JOIN RETRAITS r on a.no_article=r.no_article";
	
	private static final String SQL_SELECT_BY_ID = 			"SELECT no_article, nom_article, description,  date_debut_encheres, date_fin_encheres, "
															+ "prix_initial, prix_vente, no_utilisateur, no_categorie "
															+ "FROM ARTICLES_VENDUS WHERE no_article=?";
	
	private static final String SQL_INSERT = 				"INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, "
															+ " prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = 				"UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, "
															+ "prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=?"
															+ "WHERE no_article=?";
	
	private static final String SQL_DELETE = 				"DELETE FROM ARTICLES_VENDUS WHERE no_article=?";

	private static final String SQL_INSERT_TO_WITHDRAWAL = 	"INSERT INTO RETRAITS (no_article) values(?)";
	
	private static final String SQL_SELECT_BY_NO_CATEGORY = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, "
															+ "prix_initial, prix_vente, no_utilisateur"
															+ "FROM ARTICLES_VENDUS WHERE no_category=?";
	
	private static final String SQL_SELECT_BY_CHAR_NAME = 	"SELECT no_article, description, date_debut_encheres, date_fin_encheres, "
															+ "prix_initial, prix_vente, no_utilisateur, no_categorie "
															+ "FROM ARTICLES_VENDUS WHERE nom_article LIKE ? ";
	
	/**
	 * Constructeur
	 */
	public ArticleDAOJdbcImpl() {
	}

	@Override
	public List<Article> selectAll() throws BusinessException {
		List<Article> listeArticles = new ArrayList<Article>();
		
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs= pstmt.executeQuery();
			Article articleOnGoing = new Article();
			while(rs.next()) {
				if (rs.getInt("no_article")!= articleOnGoing.getNoArticle()) {
					articleOnGoing = articleBuilder(rs);
					listeArticles.add(articleOnGoing);
				}
			}
			rs.close();
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.SELECT_LIST_ARTICLE_FAILED);
			throw businessException;
		}
		return listeArticles;
	}
		
	@Override
	public Article selectById(Integer no_article) throws BusinessException {
		Article articleOnGoing = new Article();
		
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setInt(1, no_article);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				if (rs.next()) {
					articleOnGoing = articleBuilder(rs);
				}
			}
			rs.close();
			pstmt.close();
			cnx.close();
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.SELECT_ARTICLE_ID_FAILED);
			throw businessException;
		} 
		return articleOnGoing;
	}

	@Override
	public void insert(Article article) throws BusinessException {
		if(article==null) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ARTICLE_NULL);
			throw businessException;
		}
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				// gestion des commits
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				if (article.getNoArticle()==0) {
					pstmt = cnx.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.executeUpdate();
					rs = pstmt.getGeneratedKeys();
					if (rs.next()) {
						article.setNoArticle(rs.getInt(1));
					}
				}
			rs.close();
			pstmt.close();
			cnx.commit();
			cnx.close();
			} catch(Exception e)
			{
				e.printStackTrace();
				cnx.rollback();
				// propage potentielle exception en businessException dans catch suivant
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			// créer une businessException perso
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ARTICLE_FAILED);
			throw businessException;
		} 
	
	}

	@Override
	public void update(Article article) throws BusinessException {
		if(article==null) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ARTICLE_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			cnx.setAutoCommit(false);
			PreparedStatement pstmt = null;
			
			try {
				cnx.setAutoCommit(false);
				pstmt = cnx.prepareStatement(SQL_UPDATE);
				
				pstmt.setString(1, article.getNameArticle());
				pstmt.setString(2, article.getDescription());
				// conversion LocalDate en date sql
				pstmt.setDate(3, java.sql.Date.valueOf(article.getAuctionStartDate()));
				pstmt.setDate(4, java.sql.Date.valueOf(article.getAuctionEndDate()));
				pstmt.setInt(5, article.getOriginalPrice());
				pstmt.setInt(6, article.getSellingPrice());
				pstmt.setInt(7, article.getNoUser());
				pstmt.setInt(8, article.getNoCategory());
				pstmt.setInt(9, article.getNoUser());
				
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();
				cnx.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.UPDATE_ARTICLE_FAILED);
			throw businessException;
		}
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		if(id==null || id==0)	{
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.DELETE_ID_ARTICLE_NULL);
			throw businessException;
		}
		
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = null;
			cnx.prepareStatement(SQL_DELETE);
			
			try {
				cnx.setAutoCommit(false);
				pstmt = cnx.prepareStatement(SQL_DELETE);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				
				pstmt.close();
				cnx.commit();
				cnx.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		}catch(Exception e) {
			e.printStackTrace();
			// transforme la SQLException en businessException
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.DELETE_ARTICLE_FAILED);
			throw businessException;
		}
	}

	@Override
	public void insertToWithdrawal(Article article) throws BusinessException {
		if(article==null) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ARTICLE_NULL);
			throw businessException;
		}
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = null ;
				ResultSet rs = null;
				
				if (article.getNoArticle()==0) {
					pstmt.setInt(1, article.getNoArticle());
				}
				if(rs.next())
				{
					article.setNoArticle(rs.getInt(1));
				}
			rs.close();
			pstmt.close();
			cnx.commit();
			cnx.close();
			} catch(Exception e)
			{
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ARTICLE_TO_WITHDRAWAL_FAILED);
			throw businessException;
		} 
	}

	@Override
	public void selectByNoCategory(Article data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectByCharName(Article data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Article articleBuilder(ResultSet rs) throws SQLException {
		Article articleOngoing = new Article(
				rs.getInt("no_article"),
				rs.getString("nom_article"),
				rs.getString("description"),
				// conversion date sql en LocalDate
				rs.getDate("date_debut_encheres").toLocalDate(),
				rs.getDate("date_fin_encheres").toLocalDate(),
				rs.getInt("prix_initial"),
				rs.getInt("prix_vente"),
				rs.getInt("no_utilisateur"),
				rs.getInt("no_categorie"));
		
		Withdrawal withdrawalOngoing = new Withdrawal(
				rs.getInt("no_article"),
				rs.getString("rue"),
				rs.getString("code_postal"),
				rs.getString("ville"));
		
		articleOngoing.setWithdrawal(withdrawalOngoing);
		
		return articleOngoing;
	}
}
