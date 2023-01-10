package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de communiquer avec la BDD et la Table ENCHERES
 * @author slamire2022
 * @date 9 janv. 2023 - 15:32:43
 * @version ENI_Encheres - v0.1
 */
public class AuctionDAOJdbcImpl implements AuctionDAO {

	private static final String SQL_SELECT_ALL =	"SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM ENCHERES";
	private static final String SQL_SELECT_BY_ID = 	"SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM ENCHERES WHERE no_enchere=?";
	private static final String SQL_INSERT = 		"INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) values(?,?,?,?)";
	private static final String SQL_UPDATE = 		"UPDATE ENCHERES SET date_enchere=?, montant_enchere=?, no_article=?, no_utilisateur=? WHERE no_enchere=?";
	private static final String SQL_DELETE = 		"DELETE FROM ENCHERES WHERE no_enchere=?";
	
	/**
	 * Constructeur
	 */
	public AuctionDAOJdbcImpl() {
	}

	@Override
	public List<Auction> selectAll() throws BusinessException {
		//Déclaration d'une liste d'utilisateurs
		List<Auction> listeAuctions = new ArrayList<>();
		//Déclaration d'un Prepared Statement et initialisation à null
		PreparedStatement pstmt = null;
		//Récupération d'une connection à la BDD	
		try (Connection cnx=ConnectionProvider.getConnection()){
			//Passage de la requête au Prepared Statement
			pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			//Récupération des informations dans un ResultSet
			ResultSet rs= pstmt.executeQuery();
			//Boucler tant qu'il y a une ligne suivante
				while(rs.next()) {
				//Déclaration et instanciation d'une Auction
				Auction auctionOngoing = new Auction();
					//Sécurité
					if (rs.getInt("no_enchere") != auctionOngoing.getNoUser()) {
						//Générer une Auction à partir des infos de la BDD
						auctionOngoing = auctionBuilder(rs);
						//Ajouter cette Auction à la liste de Auction
						listeAuctions.add(auctionOngoing);
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
				return listeAuctions;
	}

	@Override
	public Auction selectById(Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Auction data) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Auction data) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws BusinessException {
		// TODO Auto-generated method stub

	}
	
	private Auction auctionBuilder(ResultSet rs) throws SQLException{
		return new Auction(
				rs.getInt("no_enchere"),
				rs.getDate("date_enchere").toLocalDate(), 
				rs.getInt("montant_enchere"),
				rs.getInt("no_article"),
				rs.getInt("no_utilisateur"));
	}

}
