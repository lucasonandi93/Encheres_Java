package fr.eni.enchere.dal.jdbc;

import java.util.List;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Classe en charge de 
 * @author slamire2022
 * @date 9 janv. 2023 - 15:21:04
 * @version ENI_Encheres - v0.1
 */
public interface AuctionDAO extends DAO<Auction, Integer>{
	public List <Auction> selectByNoArticle(Integer noArticle)throws BusinessException;
	
	public List <Auction> selectByNoUser (Integer noUser)throws BusinessException;
}
