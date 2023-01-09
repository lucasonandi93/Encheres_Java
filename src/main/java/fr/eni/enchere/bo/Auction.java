package fr.eni.enchere.bo;
import java.util.Date;

public class Auction {
	private int nbUser;
	private int nbArticle;
	private Date auctionDate;
	private int auctionAmount;
	
	public Auction() {
    }
	
	 public Auction(int nbUser, int nbArticle, Date auctionDate, int auctionAmount) {
	        this.nbUser = nbUser;
	        this.nbArticle = nbArticle;
	        this.auctionDate = auctionDate;
	        this.auctionAmount = auctionAmount;
	    }

	    public int getNbUser() {
	        return nbUser;
	    }

	    public void setNbUser(int nbUser) {
	        this.nbUser = nbUser;
	    }

	    public int getNoArticle() {
	        return nbArticle;
	    }

	    public void setNbArticle(int nbArticle) {
	        this.nbArticle = nbArticle;
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
	                "noUtilisateur=" + nbUser +
	                ", noArticle=" + nbArticle +
	                ", dateEnchere=" + auctionDate +
	                ", montantEnchere=" + auctionAmount +
	                '}';
	    }
	}
 

