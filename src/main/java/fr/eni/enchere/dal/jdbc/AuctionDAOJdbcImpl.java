package fr.eni.enchere.dal.jdbc;

import java.util.List;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de de définir les requêtes sql pour l'objet auction
 * @author slamire2022
 * @date 9 janv. 2023 - 15:32:43
 * @version ENI_Encheres - v0.1
 */
public class AuctionDAOJdbcImpl implements AuctionDAO {

	
	
	/**
	 * Constructeur
	 */
	public AuctionDAOJdbcImpl() {
	}

	@Override
	public List<Auction> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
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

}
