package fr.eni.enchere.bo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* POJE Category 
* @author ldupont2022
* @date 10 janv. 2023 - 10:37:47
* @version ENI_Encheres - v0.1
*/
public class Category implements Serializable {
   
	private static final long serialVersionUID = 3933976282091788722L;
	private int noCategory;
    private String wording;
    private List<Article> listArticle;

    /**
     * Constructeur
     */
    public Category() {
    	this.listArticle = new ArrayList<>();
    }
    
    /**
     * Constructeur
     * @param noCategory
     * @param wording
     */
    public Category(int noCategory, String wording) {
    	this();
    	this.setnoCategory(noCategory);
    	this.setWording(wording);
    }

	/**
	 * Getter pour noCategory
	 * @return the noCategory
	 */
	public int getNoCategory() {
		return noCategory;
	}

	/**
	 * Setter pour noCategory
	 * @param noCategory the noCategory to set
	 */
	public void setnoCategory(int noCategory) {
		this.noCategory = noCategory;
	}

	/**
	 * Getter pour wording
	 * @return the wording
	 */
	public String getWording() {
		return wording;
	}

	/**
	 * Setter pour wording
	 * @param wording the wording to set
	 */
	public void setWording(String wording) {
		this.wording = wording;
	}

	/**
	 * Getter pour listArticle
	 * @return the listArticle
	 */
	public List<Article> getListArticle() {
		return listArticle;
	}

	
	/**
	 * Méthode qui permet d'afficher la Category
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" - Category [getNoCategory()=");
		builder.append(getNoCategory());
		builder.append(", getWording()=");
		builder.append(getWording());
		builder.append(", getListArticle()=");
		builder.append(getListArticle());
		builder.append("]");
		return builder.toString();
	}

	
}