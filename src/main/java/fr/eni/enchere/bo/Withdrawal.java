package fr.eni.enchere.bo;

import java.io.Serializable;

/**
 * POJO Withdrawal
 * 
 * @author lucasonandi93
 * @date 10 janv. 2023 - 10:49:33
 * @version ENI_Encheres - v0.1
 */

public class Withdrawal implements Serializable {

	private static final long serialVersionUID = 2981037157673879720L;
	private int noArticle;
	private String street;
	private String cp;
	private String city;

	/**
	 * Constructeur
	 */

	public Withdrawal() {
	}

	/**
	 * Constructeur
	 * @param noArticle
	 * @param street
	 * @param cp
	 * @param city
	 */

	public Withdrawal(int noArticle, String street, String cp, String city) {
		this.setNoArticle(noArticle);
		this.setStreet(street);
		this.setCp(cp);
		this.setCity(city);
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
	 * Getter pour street
	 * @return the street
	 */

	public String getStreet() {
		return street;
	}

	/**
	 * Setter pour street
	 * @param street the street to set
	 */

	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Getter pour cp
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Setter pour cp
	 * @param cp the cp to set
	 */

	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * Getter pour city
	 * @return the city
	 */

	public String getCity() {
		return city;
	}

	/**
	 * Setter pour city
	 * @param city the city to set
	 */

	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Méthode qui permet d'afficher le Withdrawal
	 */

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" - Withdrawal [getNoArticle()=");
		builder.append(getNoArticle());
		builder.append(", getStreet()=");
		builder.append(getStreet());
		builder.append(", getCp()=");
		builder.append(getCp());
		builder.append(", getCity()=");
		builder.append(getCity());
		builder.append("]");
		return builder.toString();
	}
}