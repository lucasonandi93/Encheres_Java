package fr.eni.enchere.bo;
import java.util.Date;

public class Bid {
	private int nbUser;
	private int nbArticle;
	private Date dateBid;
	private int amountBid;
	
	public Bid() {
    }
	
	 public Bid(int noUtilisateur, int noArticle, Date dateEnchere, int montantEnchere) {
	        this.nbUser = noUtilisateur;
	        this.nbArticle = noArticle;
	        this.dateBid = dateEnchere;
	        this.amountBid = montantEnchere;
	    }

	    public int getNoUtilisateur() {
	        return nbUser;
	    }

	    public void setNoUtilisateur(int noUtilisateur) {
	        this.nbUser = noUtilisateur;
	    }

	    public int getNoArticle() {
	        return nbArticle;
	    }

	    public void setNoArticle(int noArticle) {
	        this.nbArticle = noArticle;
	    }

	    public Date getDateEnchere() {
	        return dateBid;
	    }

	    public void setDateEnchere(Date dateEnchere) {
	        this.dateBid = dateEnchere;
	    }

	    public int getMontantEnchere() {
	        return amountBid;
	    }

	    public void setMontantEnchere(int montantEnchere) {
	        this.amountBid = montantEnchere;
	    }

	    @Override
	    public String toString() {
	        return "Enchere{" +
	                "noUtilisateur=" + nbUser +
	                ", noArticle=" + nbArticle +
	                ", dateEnchere=" + dateBid +
	                ", montantEnchere=" + amountBid +
	                '}';
	    }
	}

