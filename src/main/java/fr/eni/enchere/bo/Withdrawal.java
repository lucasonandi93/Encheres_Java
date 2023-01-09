package fr.eni.enchere.bo;

import java.io.Serializable;

public class Withdrawal implements Serializable{

	private static final long serialVersionUID = 2981037157673879720L;
	private int noArticle;
	private String street;
	private String cp;
	private String city;
	 
	 public Withdrawal() {
		
	}
	 
	 public Withdrawal(int noArticle, String street, String cp, String city) {
	        this.setNoArticle(noArticle);
	        this.setStreet(street);
	        this.setCp(cp);
	        this.setCity(city);
	    }

	    public int getNoArticle() {
	        return noArticle;
	    }

	    public void setNoArticle(int nbArticle) {
	        this.noArticle = nbArticle;
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
	                "noArticle=" + noArticle +
	                ", rue='" + street + '\'' +
	                ", codePostal='" + cp + '\'' +
	                ", ville='" + city + '\'' +
	                '}';
	    }
} 