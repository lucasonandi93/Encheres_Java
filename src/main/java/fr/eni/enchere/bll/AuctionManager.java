/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.dal.jdbc.AuctionDAO;
import fr.eni.enchere.dal.jdbc.DAOFactory;
import fr.eni.enchere.exceptions.BusinessException;

/**
* Classe en charge de 
* @author ldupont2022
* @date 9 janv. 2023 - 15:57:21
* @version ENI_Encheres - v0.1
*/
public class AuctionManager implements Manager<Auction, Integer>{

	private AuctionDAO auctionDAO;
	
	/**
	 * Constructeur
	 */
	public AuctionManager() {
		this.auctionDAO = DAOFactory.getAuctionDAO();
	}
	
	@Override
	public void addData(Auction data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Integer id) throws BusinessException {
		this.auctionDAO.delete(id);
	}

	@Override
	public void updateData(Auction data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Auction> selectAll() throws BusinessException {
		return this.auctionDAO.selectAll();
	}

	@Override
	public Auction selectById(Integer id) throws BusinessException {
		return this.auctionDAO.selectById(id);
	}



}
