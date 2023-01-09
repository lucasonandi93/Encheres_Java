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
		BusinessException businessException = new BusinessException();
		this.validateData(data, businessException);
		if (!businessException.hasErrors()) {
			this.auctionDAO.insert(data);
		}else {
			throw businessException;
		}
	}

	@Override
	public void deleteData(Integer id) throws BusinessException {
		this.auctionDAO.delete(id);
	}

	@Override
	public void updateData(Auction data) throws BusinessException {
		BusinessException businessException = new BusinessException();
		this.validateData(data, businessException);
		if (!businessException.hasErrors()) {
			this.auctionDAO.update(data);
		}else {
			throw businessException;
		}
		
	}

	@Override
	public List<Auction> selectAll() throws BusinessException {
		return this.auctionDAO.selectAll();
	}

	@Override
	public Auction selectById(Integer id) throws BusinessException {
		return this.auctionDAO.selectById(id);
	}

	@Override
	public void validateData(Auction data, BusinessException businessException) throws BusinessException {
		
		ArticleManager articleManager = new ArticleManager();
		
		if (data.getNoUser()==0) {
			businessException.addError(CodesResultatBLL.RULE_AUCTION_NO_USER_ERROR);
		}
		
		if (data.getNoArticle()==0) {
			businessException.addError(CodesResultatBLL.RULE_AUCTION_NO_ARTICLE_ERROR);
		}
		
		for (Auction auction : articleManager.selectById(data.getNoArticle()).getListAuction()) {
			if (auction.getAuctionAmount() > data.getAuctionAmount()) {
				businessException.addError(CodesResultatBLL.RULE_AUCTION_AMOUNT_ERROR);
				break;
			}
		}
	}

	
}
