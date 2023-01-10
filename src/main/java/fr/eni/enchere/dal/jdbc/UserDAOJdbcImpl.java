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
 * Classe en charge de communiquer avec la BDD et la Table UTILISATEURS
 * @author slamire2022
 * @date 9 janv. 2023 - 15:32:30
 * @version ENI_Encheres - v0.1
 */
public class UserDAOJdbcImpl implements UserDAO {

	private static final String SQL_SELECT_ALL =	"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "
													+ "ville, mot_de_passe, credit, administrateur"
													+ "FROM UTILISATEURS";
	private static final String SQL_SELECT_BY_ID = 	"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "
													+ "ville, mot_de_passe, credit, administrateur"
													+ "FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String SQL_INSERT = 		"INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, "
													+ "ville, mot_de_passe, credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = 		"UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?,"
													+ " ville=?, mot_de_passe=?, credit=?, administrateur=?"
													+ "WHERE no_utilisateur=?";
	private static final String SQL_DELETE = 		"DELETE FROM UTILISATEURS WHERE no_utilisateur=?";
	
	private static final String SQL_SELECT_BY_PSEUDO_MDP = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "
													+ "ville, mot_de_passe, credit, administrateur"
													+ "FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=?";
	/**
	 * Constructeur
	 */
	public UserDAOJdbcImpl() {}

	@Override
	public List<User> selectAll() throws BusinessException {
		List<User> listeUsers = new ArrayList<>();
		PreparedStatement pstmt = null;
			
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				User userOngoing = new User();
				
				if (rs.getInt("no_utilisateur") != userOngoing.getNoUser()) {
					userOngoing = userbuilder(rs);
					listeUsers.add(userOngoing);
				}
			}
			rs.close();
			pstmt.close();
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.SELECT_LIST_USER_FAILED);
			throw businessException;
		}
		return listeUsers;
	}

	@Override
	public User selectById(Integer id) throws BusinessException {
		if(id==null || id==0)	{
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ID_USER_NULL);
			throw businessException;
		}
		
		PreparedStatement pstmt = null;	
		User userOngoing = new User();
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs= pstmt.executeQuery();
			if (rs.next() && rs.getInt("no_utilisateur") != userOngoing.getNoUser()) {
				userOngoing = userbuilder(rs);
			}
			rs.close();
			pstmt.close();
			cnx.close();
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.SELECT_USER_ID_FAILED);
			throw businessException;
		} 
		return userOngoing;
	}

	@Override
	public void insert(User user) throws BusinessException {
		if(user==null) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_USER_NULL);
			throw businessException;
		}
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = null ;
				ResultSet rs = null;
				
				if (user.getNoUser()==0) {
					pstmt = cnx.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, user.getPseudo());
					pstmt.setString(2, user.getName());
					pstmt.setString(3, user.getFirstName());
					pstmt.setString(4, user.getEmail());
					pstmt.setString(5, user.getPhone());
					pstmt.setString(6, user.getStreet());
					pstmt.setString(7, user.getCp());
					pstmt.setString(8, user.getCity());
					pstmt.setString(9, user.getPassword());
					pstmt.setInt(10, user.getCredit());
					pstmt.setBoolean(11, user.isAdministrator());
					pstmt.executeUpdate();
					rs = pstmt.getGeneratedKeys();
				}
				if(rs.next())
				{
					user.setNoUser(rs.getInt(1));
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
			businessException.addError(CodesResultatDAL.INSERT_USER_FAILED);
			throw businessException;
		} 
	}

	@Override
	public void update(User user) throws BusinessException {
		if(user==null) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_USER_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			
			cnx.setAutoCommit(false);
			PreparedStatement pstmt = null;
			
			try {
				cnx.setAutoCommit(false);
				pstmt = cnx.prepareStatement(SQL_UPDATE);
				
				pstmt.setString(1, user.getPseudo());
				pstmt.setString(2, user.getName());
				pstmt.setString(3, user.getFirstName());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getPhone());
				pstmt.setString(6, user.getStreet());
				pstmt.setString(7, user.getCp());
				pstmt.setString(8, user.getCity());
				pstmt.setString(9, user.getPassword());
				pstmt.setInt(10, user.getCredit());
				pstmt.setBoolean(11, user.isAdministrator());
				pstmt.setInt(12, user.getNoUser());
				
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
			businessException.addError(CodesResultatDAL.UPDATE_USER_FAILED);
			throw businessException;
		}
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		
		if(id==null || id==0)	{
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ID_USER_NULL);
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
			businessException.addError(CodesResultatDAL.DELETE_USER_FAILED);
			throw businessException;
		}
	}
	
	@Override
	public User selectByPseudoMdp(String pseudo, String mdp) throws BusinessException {
		if(pseudo==null || "".equals(pseudo) || mdp==null || "".equals(mdp))	{
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_PSEUDO_MDP_USER_NULL);
			throw businessException;
		}
		PreparedStatement pstmt = null;	
		User userOngoing = new User();
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			pstmt = cnx.prepareStatement(SQL_SELECT_BY_PSEUDO_MDP);
			pstmt.setString(1, pseudo);
			pstmt.setString(2, mdp);
			ResultSet rs= pstmt.executeQuery();
			if (rs.next() && rs.getInt("no_utilisateur") != userOngoing.getNoUser()) {
				userOngoing = userbuilder(rs);
			}
			rs.close();
			pstmt.close();
			cnx.close();
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.SELECT_USER_PSEUDO_MDP_FAILED);
			throw businessException;
		} 
		return userOngoing;
	}
	
	/**
	 * Méthode qui permet de générer un objet User à partir des infos de la BDD
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private User userbuilder(ResultSet rs) throws SQLException{
		return new User(
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

	
}
