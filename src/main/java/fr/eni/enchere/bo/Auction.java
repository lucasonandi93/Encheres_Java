package fr.eni.enchere.bo;
import java.io.Serializable;
import java.util.Date;

public class Auction implements Serializable{
	
	private static final long serialVersionUID = -5398583469104095201L;
	private int noUser;
	private int noArticle;
	private Date auctionDate;
	private int auctionAmount;
	
	public Auction() {
		this.auctionDate = new Date();
    }
	
	
	 public Auction(int noUser, int noArticle, int auctionAmount) {
		 this();
		 this.setNoUser(noUser);
		 this.setNoArticle(noArticle);
		 this.setAuctionAmount(auctionAmount);
	  }

	    public int getNoUser() {
	        return noUser;
	    }

	    public void setNoUser(int nbUser) {
	        this.noUser = nbUser;
	    }

	    public int getNoArticle() {
	        return noArticle;
	    }

	    public void setNoArticle(int nbArticle) {
	        this.noArticle = nbArticle;
	    }

	    public Date getAuctionDate() {
	        return auctionDate;
	    }

	    public void setAuctionDate(Date auctionDate) {
	        this.auctionDate = auctionDate;
	    }

	    public int getAuctionAmount() {
	        return auctionAmount;
	    }

	    public void setAuctionAmount(int auctionAmount) {
	        this.auctionAmount = auctionAmount;
	    }

	    @Override
	    public String toString() {
	        return "Enchere{" +
	                "noUtilisateur=" + noUser +
	                ", noArticle=" + noArticle +
	                ", dateEnchere=" + auctionDate +
	                ", montantEnchere=" + auctionAmount +
	                '}';
	    }
	} 