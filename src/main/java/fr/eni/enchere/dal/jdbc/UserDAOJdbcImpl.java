/**
 * 
 */
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
 * Classe en charge de définir les requêtes sql
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
				listeUsers.add(new User (rs.getInt("no_utilisateur"),rs.getString("pseudo"),rs.getString("nom"), rs.getString("prenom"), 
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), 
						rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur")));
			}
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.LECTURE_LISTE_ECHEC);
			throw businessException;
		} finally {
			try {
				// Verifier si le statement n'est pas null
				if (pstmt != null) {
					// Si il est pas nul fermer le statement (Mettre fin à la requète)
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// Fermer la connection
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listeUsers;
	}

	@Override
	public User selectById(Integer no_utilisateur) throws BusinessException {
//		PreparedStatement pstmt = null;
//		User user = null;
//		
//		try (Connection cnx=ConnectionProvider.getConnection())
//		{
//			pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
//			// Setter les ? de la commande SQL
//			pstmt.setInt(1, no_utilisateur);
//			
//			ResultSet rs= pstmt.executeQuery();
//			if (rs.next()) {
//				// si l'utilisateur existe
//				
//			}
//			
//			
//		}
		return null;
	}

	@Override
	public void insert(User data) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User data) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws BusinessException {
		// TODO Auto-generated method stub

	}

}
