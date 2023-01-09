package fr.eni.enchere.bo;

import java.io.Serializable;

public class Withdrawal implements Serializable{

	private static final long serialVersionUID = 2981037157673879720L;
	private int nbArticle;
	private String street;
	private String cp;
	private String city;
	 
	 public Withdrawal() {
		
	}
	 
	 public Withdrawal(int nbArticle, String street, String cp, String city) {
	        this.nbArticle = nbArticle;
	        this.street = street;
	        this.cp = cp;
	        this.city = city;
	    }

	    public int getNbArticle() {
	        return nbArticle;
	    }

	    public void setNbArticle(int nbArticle) {
	        this.nbArticle = nbArticle;
	    }

	    public String getStreet() {
	        return street;
	    }

	    public void setStreet(String street) {
	        this.street = street;
	    }

	    public String getCp() {
	        return cp;
	    }

	    public void setCp(String cp) {
	        this.cp = cp;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    @Override
	    public String toString() {
	        return "Retrait{" +
	                "noArticle=" + nbArticle +
	                ", rue='" + street + '\'' +
	                ", codePostal='" + cp + '\'' +
	                ", ville='" + city + '\'' +
	                '}';
	    }
}