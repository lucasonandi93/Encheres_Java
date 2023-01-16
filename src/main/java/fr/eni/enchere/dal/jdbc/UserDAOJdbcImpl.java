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
													+ "ville, mot_de_passe, credit, administrateur "
													+ "FROM UTILISATEURS";
	private static final String SQL_SELECT_BY_ID = 	"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "
													+ "ville, mot_de_passe, credit, administrateur "
													+ "FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String SQL_INSERT = 		"INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, "
													+ "ville, mot_de_passe, credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = 		"UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?,"
													+ " ville=?, mot_de_passe=?, credit=?, administrateur=? "
													+ "WHERE no_utilisateur=?";
	private static final String SQL_DELETE = 		"DELETE FROM UTILISATEURS WHERE no_utilisateur=?";
	
	private static final String SQL_SELECT_BY_PSEUDO_MDP = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "
													+ "ville, mot_de_passe, credit, administrateur "
													+ "FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=?";

	/**
	 * Constructeur
	 */
	public UserDAOJdbcImpl() {}

	@Override
	public List<User> selectAll() throws BusinessException {
		//Déclaration d'une liste d'utilisateurs
		List<User> listUsers = new ArrayList<>();
		//Déclaration d'un Prepared Statement et initialisation à null
		PreparedStatement pstmt = null;
		//Récupération d'une connection à la BDD	
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			//Passage de la requête au Prepared Statement
			pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			//Récupération des informations dans un ResultSet
			ResultSet rs= pstmt.executeQuery();
			//Boucler tant qu'il y a une ligne suivante
			while(rs.next()) {
				//Déclaration et instanciation d'un User
				User userOngoing = new User();
				//Sécurité
				if (rs.getInt("no_utilisateur") != userOngoing.getNoUser()) {
					//Générer un User à partir des infos de la BDD
					userOngoing = userBuilder(rs);
					//Ajouter ce User à la liste de User
					listUsers.add(userOngoing);
				}
			}
			//Fermer le ResultSet
			rs.close();
			//Fermer le Statement
			pstmt.close();
			//Fermer la connection
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
			//Déclarer une BusinessException
			BusinessException businessException = new BusinessException();
			//Si il y a une erreur, ajouter l'erreur à la BusinessException
			businessException.addError(CodesResultatDAL.SELECT_LIST_USER_FAILED);
			//Envoyer l'exception
			throw businessException;
		}
		//Return la liste de tous les utilisateurs
		return listUsers;
	}

	@Override
	public User selectById(Integer id) throws BusinessException {
		//Vérification si le paramêtre est valide
		if(id==null || id==0)	{
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ID_USER_NULL);
			throw businessException;
		}
		//Déclaration d'un Prepared Statement et initialisation à null
		PreparedStatement pstmt = null;	
		//Déclaration et instanciation d'un User
		User userOngoing = new User();
		//Récupération d'une connection à la BDD	
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			//Passage de la requête au Prepared Statement
			pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			//Setter le paramètre de la requète SQL
			pstmt.setInt(1, id);
			//Récupération des informations dans un ResultSet
			ResultSet rs= pstmt.executeQuery();
			//S'il y a une ligne suivante
			if (rs.next() && rs.getInt("no_utilisateur") != userOngoing.getNoUser()) {
				//Générer un User à partir des infos de la BDD
				userOngoing = userBuilder(rs);
			}
			//Fermer le ResultSet
			rs.close();
			//Fermer le Statement
			pstmt.close();
			//Fermer la connection
			cnx.close();
		}catch(Exception e) {
			e.printStackTrace();
			//Déclarer une BusinessException
			BusinessException businessException = new BusinessException();
			//Si il y a une erreur, ajouter l'erreur à la BusinessException
			businessException.addError(CodesResultatDAL.SELECT_USER_ID_FAILED);
			//Envoyer l'exception
			throw businessException;
		} 
		return userOngoing;
	}

	@Override
	public void insert(User user) throws BusinessException {
		//Vérification si le paramêtre est valide
		if(user==null) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_USER_NULL);
			throw businessException;
		}
		//Récupération d'une connection à la BDD	
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				//Mettre l'autoCommit à false
				cnx.setAutoCommit(false);
				//Déclaration d'un Prepared Statement et initialisation à null
				PreparedStatement pstmt = null ;
				//Déclaration d'un ResultSet et initialisation à null
				ResultSet rs = null;
				//Si le User n'a pas de no_utilisateur
				if (user.getNoUser()==0) {
					//Passage de la requête au Prepared Statement et récupérer la clé générée
					pstmt = cnx.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
					//Setter les paramètre de la requète SQL
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
					//Executer la requête
					pstmt.executeUpdate();
					//Récupérer la clé générée dans le  ResultSet
					rs = pstmt.getGeneratedKeys();
				}
				//S'il y a une clé
				if(rs.next())
				{
					//Setter le numéro d'utilisateur avec la clé
					user.setNoUser(rs.getInt(1));
				}
				//Fermer le ResultSet
				rs.close();
				//Fermer le Statement
				pstmt.close();
				//Commit
				cnx.commit();
				//Fermer la connection
				cnx.close();
			} catch(Exception e)
			{
				e.printStackTrace();
				//Si il y a une erreur rollback et la méthode n'est pas executée
				cnx.rollback();
				//Envoyer l'exception
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//Déclarer une BusinessException
			BusinessException businessException = new BusinessException();
			//Si il y a une erreur, ajouter l'erreur à la BusinessException
			businessException.addError(CodesResultatDAL.INSERT_USER_FAILED);
			//Envoyer l'exception
			throw businessException;
		} 
	}

	@Override
	public void update(User user) throws BusinessException {
		//Vérification si le paramêtre est valide
		if(user==null) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_USER_NULL);
			throw businessException;
		}
		//Récupération d'une connection à la BDD	
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			//Mettre l'autoCommit à false
			cnx.setAutoCommit(false);
			//Déclaration d'un Prepared Statement et initialisation à null
			PreparedStatement pstmt = null;
			
			try {
				//Passage de la requête au Prepared Statement
				pstmt = cnx.prepareStatement(SQL_UPDATE);
				//Setter les paramètre de la requète SQL
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
				//Executer la requête
				pstmt.executeUpdate();
				
				//Fermer le Statement
				pstmt.close();
				//Commit
				cnx.commit();
				//Fermer la connection
				cnx.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				//Si il y a une erreur rollback et la méthode n'est pas executée
				cnx.rollback();
				//Envoyer l'exception
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			//Déclarer une BusinessException
			BusinessException businessException = new BusinessException();
			//Si il y a une erreur, ajouter l'erreur à la BusinessException
			businessException.addError(CodesResultatDAL.UPDATE_USER_FAILED);
			//Envoyer l'exception
			throw businessException;
		}
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		//Vérification si le paramêtre est valide
		if(id==null || id==0)	{
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ID_USER_NULL);
			throw businessException;
		}
		//Récupération d'une connection à la BDD	
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			//Mettre l'autoCommit à false
			cnx.setAutoCommit(false);
			//Déclaration d'un Prepared Statement et initialisation à null
			PreparedStatement pstmt = null;
			
			try {
				//Passage de la requête au Prepared Statement
				pstmt = cnx.prepareStatement(SQL_DELETE);
				//Setter les paramètre de la requète SQL
				pstmt.setInt(1, id);
				//Executer la requête
				pstmt.executeUpdate();
				
				//Fermer le Statement
				pstmt.close();
				//Commit
				cnx.commit();
				//Fermer la connection
				cnx.close();
			} catch (Exception e) {
				e.printStackTrace();
				//Si il y a une erreur rollback et la méthode n'est pas executée
				cnx.rollback();
				//Envoyer l'exception
				throw e;
			}
		}catch(Exception e) {
			e.printStackTrace();
			//Déclarer une BusinessException
			BusinessException businessException = new BusinessException();
			//Si il y a une erreur, ajouter l'erreur à la BusinessException
			businessException.addError(CodesResultatDAL.DELETE_USER_FAILED);
			//Envoyer l'exception
			throw businessException;
		}
	}
	
	@Override
	public User selectByPseudoMdp(String pseudo, String mdp) throws BusinessException {
		//Vérification si le paramêtre est valide
		if(pseudo==null || "".equals(pseudo) || mdp==null || "".equals(mdp))	{
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_PSEUDO_MDP_USER_NULL);
			throw businessException;
		}
		//Déclaration d'un Prepared Statement et initialisation à null
		PreparedStatement pstmt = null;	
		//Déclaration et instanciation d'un User
		User userOngoing = new User();
		//Récupération d'une connection à la BDD	
		try (Connection cnx=ConnectionProvider.getConnection())
		{
			//Passage de la requête au Prepared Statement
			pstmt = cnx.prepareStatement(SQL_SELECT_BY_PSEUDO_MDP);
			//Setter les paramètre de la requète SQL
			pstmt.setString(1, pseudo);
			pstmt.setString(2, mdp);
			//Récupération des informations dans un ResultSet
			ResultSet rs= pstmt.executeQuery();
			//Vérification si la requète à récupérer des infos
			if (rs.next() && rs.getInt("no_utilisateur") != userOngoing.getNoUser()) {
				//Générer un User à partir des infos de la BDD
				userOngoing = userBuilder(rs);
			}
			//Fermer le ResultSet
			rs.close();
			//Fermer le Statement
			pstmt.close();
			//Fermer la connection
		}catch(Exception e) {
			e.printStackTrace();
			//Déclarer une BusinessException
			BusinessException businessException = new BusinessException();
			//Si il y a une erreur, ajouter l'erreur à la BusinessException
			businessException.addError(CodesResultatDAL.SELECT_USER_PSEUDO_MDP_FAILED);
			//Envoyer l'exception
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
	private User userBuilder(ResultSet rs) throws SQLException{
		User userOngoing = new User();
		
		userOngoing.setNoUser(rs.getInt("no_utilisateur"));
		userOngoing.setPseudo(rs.getString("pseudo"));
		userOngoing.setName(rs.getString("nom"));
		userOngoing.setFirstName(rs.getString("prenom"));
		userOngoing.setEmail(rs.getString("email"));
		userOngoing.setPhone(rs.getString("telephone"));
		userOngoing.setStreet(rs.getString("rue"));
		userOngoing.setCp(rs.getString("code_postal"));
		userOngoing.setCity(rs.getString("ville"));
		userOngoing.setPassword(rs.getString("mot_de_passe"));
		userOngoing.setCredit(rs.getInt("credit"));
		userOngoing.setAdministrator(rs.getBoolean("administrateur"));
		return userOngoing;
	}
}
