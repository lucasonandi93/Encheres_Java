/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.exceptions.BusinessException;

/**
* Classe en charge de 
* @author ldupont2022
* @date 9 janv. 2023 - 15:57:21
* @version ENI_Encheres - v0.1
*/
public class AuctionManager implements Manager<Auction, Integer>{

	@Override
	public void addData(Auction data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(Auction data) throws BusinessException {
		// TODO Auto-generated method stub
		
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



}
