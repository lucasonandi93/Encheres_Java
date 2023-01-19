package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.AuctionDAO;
import fr.eni.enchere.dal.CodesResultatDAL;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UserDAO;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de communiquer avec la BDD et la Table ENCHERES
 * 
 * @author slamire2022
 * @date 9 janv. 2023 - 15:32:43
 * @version ENI_Encheres - v0.1
 */
public class AuctionDAOJdbcImpl implements AuctionDAO {

	private static final String SQL_SELECT_ALL = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM ENCHERES";
	private static final String SQL_SELECT_BY_ID = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM ENCHERES WHERE no_enchere=?";
	private static final String SQL_INSERT = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) values(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE ENCHERES SET date_enchere=?, montant_enchere=?, no_article=?, no_utilisateur=? WHERE no_enchere=?";
	private static final String SQL_DELETE = "DELETE FROM ENCHERES WHERE no_enchere=?";
	private static final String SQL_SELECT_BY_NO_ARTICLE = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM ENCHERES WHERE no_article=?";
	private static final String SQL_SELECT_BY_USER = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM ENCHERES WHERE no_utilisateur=?";

	/**
	 * Constructeur
	 */
	public AuctionDAOJdbcImpl() {
	}

	@Override
	public List<Auction> selectAll() throws BusinessException {
		// Déclaration d'une liste d'utilisateurs
		List<Auction> listAuctions = new ArrayList<>();
		// Déclaration d'un Prepared Statement et initialisation à null
		PreparedStatement pstmt = null;
		// Récupération d'une connection à la BDD
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// Passage de la requête au Prepared Statement
			pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			// Récupération des informations dans un ResultSet
			ResultSet rs = pstmt.executeQuery();
			// Boucler tant qu'il y a une ligne suivante
			while (rs.next()) {
				// Déclaration et instanciation d'une Auction
				Auction auctionOngoing = new Auction();
				// Sécurité
				if (rs.getInt("no_enchere") != auctionOngoing.getNoAuction()) {
					// Générer une Auction à partir des infos de la BDD
					auctionOngoing = auctionBuilder(rs);
					// Ajouter cette Auction à la liste de Auction
					listAuctions.add(auctionOngoing);
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
			businessException.addError(CodesResultatDAL.SELECT_LIST_AUCTION_FAILED);
			// Envoyer l'exception
			throw businessException;
		}
		// Return la liste de tous les utilisateurs
		return listAuctions;
	}

	@Override
	public Auction selectById(Integer id) throws BusinessException {
		// Vérification si le paramêtre est valide
		if (id == null || id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ID_AUCTION_NULL);
			throw businessException;
		}
		// Déclaration d'un Prepared Statement et initialisation à null
		PreparedStatement pstmt = null;
		// Déclaration et instanciation d'une Auction
		Auction auctionOngoing = new Auction();
		// Récupération d'une connection à la BDD
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// Passage de la requête au Prepared Statement
			pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			// Setter les paramètre de la requète SQL
			pstmt.setInt(1, id);
			// Récupération des informations dans un ResultSet
			ResultSet rs = pstmt.executeQuery();
			// S'il y a une ligne suivante
			if (rs.next() && rs.getInt("no_enchere") != auctionOngoing.getNoAuction()) {
				// Générer une Auction à partir des infos de la BDD
				auctionOngoing = auctionBuilder(rs);
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
			businessException.addError(CodesResultatDAL.SELECT_AUCTION_ID_FAILED);
			// Envoyer l'exception
			throw businessException;
		}
		return auctionOngoing;
	}

	@Override
	public void insert(Auction auction) throws BusinessException {
		// Vérification si le paramêtre est valide
		if (auction == null) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_AUCTION_NULL);
			throw businessException;
		}
		// Récupération d'une connection à la BDD
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				// Mettre l'autoCommit à false
				cnx.setAutoCommit(false);
				// Déclaration d'un Prepared Statement et initialisation à null
				PreparedStatement pstmt = null;
				// Déclaration d'un ResultSet et initialisation à null
				ResultSet rs = null;
				// Si le User n'a pas de no_utilisateur
				if (auction.getNoAuction() == 0) {
					// Passage de la requête au Prepared Statement et récupérer la clé générée
					pstmt = cnx.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
					// Setter les paramètre de la requète SQL
					pstmt.setDate(1, java.sql.Date.valueOf(auction.getAuctionDate()));
					pstmt.setInt(2, auction.getAuctionAmount());
					pstmt.setInt(3, auction.getArticle().getNoArticle());
					pstmt.setInt(4, auction.getUser().getNoUser());
					// Executer la requête
					pstmt.executeUpdate();
					// Récupérer la clé générée dans le ResultSet
					rs = pstmt.getGeneratedKeys();
				}
				// S'il y a une clé
				if (rs.next()) {
					// Setter le numéro d'enchère avec la clé
					auction.setNoAuction(rs.getInt(1));
				}
				// Fermer le ResultSet
				rs.close();
				// Fermer le Statement
				pstmt.close();
				// Commit
				cnx.commit();
				// Fermer la connection
				cnx.close();
			} catch (Exception e) {
				e.printStackTrace();
				// Si il y a une erreur rollback et la méthode n'est pas executée
				cnx.rollback();
				// Envoyer l'exception
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Déclarer une BusinessException
			BusinessException businessException = new BusinessException();
			// Si il y a une erreur, ajouter l'erreur à la BusinessException
			businessException.addError(CodesResultatDAL.INSERT_AUCTION_FAILED);
			// Envoyer l'exception
			throw businessException;
		}

	}

	@Override
	public void update(Auction auction) throws BusinessException {
		// Vérification si le paramêtre est valide
		if (auction == null) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_AUCTION_NULL);
			throw businessException;
		}
		// Récupération d'une connection à la BDD
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// Mettre l'autoCommit à false
			cnx.setAutoCommit(false);
			// Déclaration d'un Prepared Statement et initialisation à null
			PreparedStatement pstmt = null;
			try {
				// Passage de la requête au Prepared Statement
				pstmt = cnx.prepareStatement(SQL_UPDATE);
				// Setter les paramètre de la requète SQL
				pstmt.setDate(1, java.sql.Date.valueOf(auction.getAuctionDate()));
				pstmt.setInt(2, auction.getAuctionAmount());
				pstmt.setInt(3, auction.getArticle().getNoArticle());
				pstmt.setInt(4, auction.getUser().getNoUser());
				pstmt.setInt(5, auction.getNoAuction());
				// Executer la requête
				pstmt.executeUpdate();

				// Fermer le Statement
				pstmt.close();
				// Commit
				cnx.commit();
				// Fermer la connection
				cnx.close();
			} catch (Exception e) {
				e.printStackTrace();
				// Si il y a une erreur rollback et la méthode n'est pas executée
				cnx.rollback();
				// Envoyer l'exception
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Déclarer une BusinessException
			BusinessException businessException = new BusinessException();
			// Si il y a une erreur, ajouter l'erreur à la BusinessException
			businessException.addError(CodesResultatDAL.UPDATE_AUCTION_FAILED);
			// Envoyer l'exception
			throw businessException;
		}
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		// Vérification si le paramêtre est valide
		if (id == null || id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ID_AUCTION_NULL);
			throw businessException;
		}
		// Récupération d'une connection à la BDD
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// Mettre l'autoCommit à false
			cnx.setAutoCommit(false);
			// Déclaration d'un Prepared Statement et initialisation à null
			PreparedStatement pstmt = null;
			try {
				// Passage de la requête au Prepared Statement
				pstmt = cnx.prepareStatement(SQL_DELETE);
				// Setter les paramètre de la requète SQL
				pstmt.setInt(1, id);
				// Executer la requête
				pstmt.executeUpdate();

				// Fermer le Statement
				pstmt.close();
				// Commit
				cnx.commit();
				// Fermer la connection
				cnx.close();
			} catch (Exception e) {
				e.printStackTrace();
				// Si il y a une erreur rollback et la méthode n'est pas executée
				cnx.rollback();
				// Envoyer l'exception
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Déclarer une BusinessException
			BusinessException businessException = new BusinessException();
			// Si il y a une erreur, ajouter l'erreur à la BusinessException
			businessException.addError(CodesResultatDAL.DELETE_AUCTION_FAILED);
			// Envoyer l'exception
			throw businessException;
		}
	}

	/**
	 * Méthode qui permet de générer un objet Auction à partir des infos de la BDD
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws BusinessException
	 */
	private Auction auctionBuilder(ResultSet rs) throws SQLException, BusinessException {

		ArticleDAO articleDAO = DAOFactory.getArticleDAO();
		UserDAO userDAO = DAOFactory.getUserDAO();

		Auction auctionOngoing = new Auction();
		auctionOngoing.setNoAuction(rs.getInt("no_enchere"));
		auctionOngoing.setAuctionDate(rs.getDate("date_enchere").toLocalDate());
		auctionOngoing.setAuctionAmount(rs.getInt("montant_enchere"));
		auctionOngoing.setArticle(articleDAO.selectById(rs.getInt("no_article")));
		auctionOngoing.setUser(userDAO.selectById(rs.getInt("no_utilisateur")));

		return auctionOngoing;
	}

	@Override
	public List<Auction> selectByNoArticle(Integer noArticle) throws BusinessException {
		// Vérification si le paramêtre est valide
		if (noArticle == null || noArticle == 0) {
			BusinessException businessException = new BusinessException();
			businessException.addError(CodesResultatDAL.INSERT_ID_AUCTION_NULL);
			throw businessException;
		}

		// Déclaration d'une liste d'utilisateurs
		List<Auction> listAuctions = new ArrayList<>();
		// Déclaration d'un Prepared Statement et initialisation à null
		PreparedStatement pstmt = null;
		// Récupération d'une connection à la BDD
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// Passage de la requête au Prepared Statement
			pstmt = cnx.prepareStatement(SQL_SELECT_BY_NO_ARTICLE);
			pstmt.setInt(1, noArticle);
			// Récupération des informations dans un ResultSet
			ResultSet rs = pstmt.executeQuery();
			// Boucler tant qu'il y a une ligne suivante
			while (rs.next()) {
				// Déclaration et instanciation d'une Auction
				Auction auctionOngoing = new Auction();
				// Sécurité
				if (rs.getInt("no_enchere") != auctionOngoing.getNoAuction()) {
					// Générer une Auction à partir des infos de la BDD
					auctionOngoing = auctionBuilder(rs);
					// Ajouter cette Auction à la liste de Auction
					listAuctions.add(auctionOngoing);
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
			businessException.addError(CodesResultatDAL.SELECT_LIST_AUCTION_FAILED);
			// Envoyer l'exception
			throw businessException;
		}
		// Return la liste de tous les utilisateurs
		return listAuctions;
	}

	@Override
	public List<Auction> selectByNoUser(Integer noUser) throws BusinessException {
		// Vérification si le paramêtre est valide
				if (noUser == null || noUser == 0) {
					BusinessException businessException = new BusinessException();
					businessException.addError(CodesResultatDAL.INSERT_ID_AUCTION_NULL);
					throw businessException;
				}

				// Déclaration d'une liste d'utilisateurs
				List<Auction> listAuctions = new ArrayList<>();
				// Déclaration d'un Prepared Statement et initialisation à null
				PreparedStatement pstmt = null;
				// Récupération d'une connection à la BDD
				try (Connection cnx = ConnectionProvider.getConnection()) {
					// Passage de la requête au Prepared Statement
					pstmt = cnx.prepareStatement(SQL_SELECT_BY_USER);
					pstmt.setInt(1, noUser);
					// Récupération des informations dans un ResultSet
					ResultSet rs = pstmt.executeQuery();
					// Boucler tant qu'il y a une ligne suivante
					while (rs.next()) {
						// Déclaration et instanciation d'une Auction
						Auction auctionOngoing = new Auction();
						// Sécurité
						if (rs.getInt("no_enchere") != auctionOngoing.getNoAuction()) {
							// Générer une Auction à partir des infos de la BDD
							auctionOngoing = auctionBuilder(rs);
							// Ajouter cette Auction à la liste de Auction
							listAuctions.add(auctionOngoing);
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
					businessException.addError(CodesResultatDAL.SELECT_LIST_AUCTION_FAILED);
					// Envoyer l'exception
					throw businessException;
				}
				// Return la liste de tous les utilisateurs
				return listAuctions;
	}

}
