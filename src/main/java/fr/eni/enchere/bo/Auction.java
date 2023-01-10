package fr.eni.enchere.bo;
import java.io.Serializable;
import java.util.Date;

/**
* POJO Auction
* @author ldupont2022
* @date 10 janv. 2023 - 10:34:15
* @version ENI_Encheres - v0.1
*/
public class Auction implements Serializable{
	
	private static final long serialVersionUID = -5398583469104095201L;
	private int noUser;
	private int noArticle;
	private Date auctionDate;
	private int auctionAmount;
	
	/**
	 * Constructeur
	 */
	public Auction() {
		this.auctionDate = new Date();
    }
	
	
	 /**
	 * Constructeur
	 * @param noUser
	 * @param noArticle
	 * @param auctionAmount
	 */
	public Auction(int noUser, int noArticle, int auctionAmount) {
		 this();
		 this.setNoUser(noUser);
		 this.setNoArticle(noArticle);
		 this.setAuctionAmount(auctionAmount);
	  }

	    /**
	 * Getter pour noUser
	 * @return the noUser
	 */
	public int getNoUser() {
		return noUser;
	}

	/**
	 * Setter pour noUser
	 * @param noUser the noUser to set
	 */
	public void setNoUser(int noUser) {
		this.noUser = noUser;
	}

	/**
	 * Getter pour noArticle
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}

	/**
	 * Setter pour noArticle
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * Getter pour auctionDate
	 * @return the auctionDate
	 */
	public Date getAuctionDate() {
		return auctionDate;
	}

	/**
	 * Setter pour auctionDate
	 * @param auctionDate the auctionDate to set
	 */
	public void setAuctionDate(Date auctionDate) {
		this.auctionDate = auctionDate;
	}

	/**
	 * Getter pour auctionAmount
	 * @return the auctionAmount
	 */
	public int getAuctionAmount() {
		return auctionAmount;
	}

	/**
	 * Setter pour auctionAmount
	 * @param auctionAmount the auctionAmount to set
	 */
	public void setAuctionAmount(int auctionAmount) {
		this.auctionAmount = auctionAmount;
	}


	
	/**
	 * Méthode qui permet d'afficher l'Auction
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" - Auction [getNoUser()=");
		builder.append(getNoUser());
		builder.append(", getNoArticle()=");
		builder.append(getNoArticle());
		builder.append(", getAuctionDate()=");
		builder.append(getAuctionDate());
		builder.append(", getAuctionAmount()=");
		builder.append(getAuctionAmount());
		builder.append("]");
		return builder.toString();
	}

	
	} 