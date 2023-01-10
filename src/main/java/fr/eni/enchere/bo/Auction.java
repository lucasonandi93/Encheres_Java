package fr.eni.enchere.bo;
import java.io.Serializable;
import java.time.LocalDate;

/**
* POJO Auction
* @author ldupont2022
* @date 10 janv. 2023 - 10:34:15
* @version ENI_Encheres - v0.1
*/
public class Auction implements Serializable{
	
	private static final long serialVersionUID = -5398583469104095201L;
	private int noAuction;
	private int noUser;
	private int noArticle;
	private LocalDate auctionDate;
	private int auctionAmount;
	
	/**
	 * Constructeur
	 */
	public Auction() {
		this.auctionDate = LocalDate.now();
	}
	
	/**
	 * Constructeur
	 * @param auctionAmount
	 * @param noUser
	 * @param noArticle
	 */
	public Auction(int auctionAmount, int noUser, int noArticle) {
		this();
		 this.setAuctionAmount(auctionAmount);
		 this.setNoUser(noUser);
		 this.setNoArticle(noArticle);
	}
	
	 /**
	 * Constructeur
	 * @param noUser
	 * @param noArticle
	 * @param auctionAmount
	 */
	public Auction(LocalDate auctionDate, int auctionAmount, int noUser, int noArticle) {
		 this(auctionAmount, noUser, noArticle);
		 this.setAuctionDate(auctionDate);
	  }
	
	/**
	 * Constructeur
	 * @param noAuction
	 * @param auctionDate
	 * @param auctionAmount
	 * @param noUser
	 * @param noArticle
	 */
	public Auction(int noAuction, LocalDate auctionDate, int auctionAmount, int noUser, int noArticle) {
		this(auctionDate, auctionAmount, noUser, noArticle);
		this.setNoAuction(noAuction);
	}
	
	    /**
	 * Getter pour noAuction
	 * @return the noAuction
	 */
	public int getNoAuction() {
		return noAuction;
	}

	/**
	 * Setter pour noAuction
	 * @param noAuction the noAuction to set
	 */
	public void setNoAuction(int noAuction) {
		this.noAuction = noAuction;
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
	public LocalDate getAuctionDate() {
		return auctionDate;
	}

	/**
	 * Setter pour auctionDate
	 * @param auctionDate the auctionDate to set
	 */
	public void setAuctionDate(LocalDate auctionDate) {
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