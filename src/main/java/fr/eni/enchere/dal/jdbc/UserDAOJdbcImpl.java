package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de définir les requêtes sql pour l'objet user
 * @author slamire2022
 * @date 9 janv. 2023 - 15:32:30
 * @version ENI_Encheres - v0.1
 */
public class UserDAOJdbcImpl implements UserDAO {

	private static final String SQL_SELECT_ALL = 	"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "
												+ "ville, mot_de_passe, credit, administrateur FROM UTILISATEURS";
	private static final String SQL_SELECT_BY_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "
												+ "ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String SQL_INSERT = 	"INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, "
												+ "ville, mot_de_passe, credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = 	"UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?,"
												+ " ville=?, mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur=?";
	private static final String SQL_DELETE = 	"DELETE FROM UTILISATEURS where WHERE no_utilisateur=?";
	
	private static Connection connection = null;
	
	/**
	 * Constructeur
	 */
	public UserDAOJdbcImpl() {
	}

	@Override
	public List<User> selectAll() throws BusinessException {
		List<User> listeUsers = new ArrayList<User>();
		PreparedStatement pstmt = null;
			
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				listeUsers.add(new User(rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"), 
						rs.getString("prenom"), 
						rs.getString("email"), 
						rs.getString("telephone"), 
						rs.getString("rue"), 
						rs.getString("code_postal"), 
						rs.getString("ville"), 
						rs.getString("mot_de_passe"), 
						rs.getInt("credit"), 
						rs.getBoolean("administrateur")));
			}
			rs.close();
			pstmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.LECTURE_LISTE_ECHEC);
			throw businessException;
		}
		return listeUsers;
	}

	@Override
	public User selectById(Integer no_utilisateur) throws BusinessException {
		PreparedStatement pstmt = null;
		User user = null;
		
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setInt(1, no_utilisateur);
			ResultSet rs= pstmt.executeQuery();
		
			if (rs.next()) {
					user = new User (
						rs.getInt("no_utilisateur"),
						rs.getString("pseudo"), 
						rs.getString("nom"),
						rs.getString("prenom"), 
						rs.getString("email"),
						rs.getString("telephone"), 
						rs.getString("rue"), 
						rs.getString("code_postal"),
						rs.getString("ville"), 
						rs.getString("mot_de_passe"), 
						rs.getInt("credit"), 
						rs.getBoolean("administrateur"));
			}
			rs.close();
			pstmt.close();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		} 
		return user;
	}

	@Override
	public void insert(User user) throws BusinessException {
		if(user==null) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				// gestion des commits
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					user.setNoUser(rs.getInt(1));
				}
			rs.close();
			pstmt.close();
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
			businessException.addError(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		} 
	}

	@Override
	public void update(User data) throws BusinessException {
		PreparedStatement pstmt = null;
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
				pstmt = cnx.prepareStatement(SQL_UPDATE);
				
				pstmt.setString(1, data.getPseudo());
				pstmt.setString(2, data.getName());
				pstmt.setString(3, data.getFirstName());
				pstmt.setString(4, data.getEmail());
				pstmt.setString(5, data.getPhone());
				pstmt.setString(6, data.getStreet());
				pstmt.setString(7, data.getCp());
				pstmt.setString(8, data.getCity());
				pstmt.setString(9, data.getPassword());
				pstmt.setInt(10, data.getCredit());
				pstmt.setBoolean(11, data.isAdministrator());
				
				pstmt.executeUpdate();
				pstmt.close();
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			// transforme la SQLException en businessException
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.SUPPRESSION_USER_ERREUR);
			throw businessException;
		}
	}
}
