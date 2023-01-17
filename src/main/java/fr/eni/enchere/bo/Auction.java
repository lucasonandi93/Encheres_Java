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
	private User user;
	private Article article;
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
	 * @param user
	 * @param article
	 */
	public Auction(int auctionAmount, User user, Article article) {
		this();
		 this.setAuctionAmount(auctionAmount);
		 this.setUser(user);
		 this.setArticle(article);
	}
	
	 /**
	 * Constructeur
	 * @param noUser
	 * @param noArticle
	 * @param auctionAmount
	 */
	public Auction(LocalDate auctionDate, int auctionAmount, User user, Article article) {
		 this(auctionAmount, user, article);
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
	public Auction(int noAuction, LocalDate auctionDate, int auctionAmount, User user, Article article) {
		this(auctionDate, auctionAmount, user, article);
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
	 * Getter pour user.
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Setter pour user
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Getter pour article.
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * Setter pour article
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
	
	/**
	 * Méthode qui permet d'afficher l'Auction
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" - Auction [getUser()=");
		builder.append(getUser());
		builder.append(", getArticle()=");
		builder.append(getArticle());
		builder.append(", getAuctionDate()=");
		builder.append(getAuctionDate());
		builder.append(", getAuctionAmount()=");
		builder.append(getAuctionAmount());
		builder.append("]");
		return builder.toString();
	}

	
	} 