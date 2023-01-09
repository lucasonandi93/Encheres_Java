package fr.eni.enchere.bo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
   
	private static final long serialVersionUID = 3933976282091788722L;
	private int nbCategory;
    private String wording;
    private List<Article> listArticle;

    public Category() {
    	this.listArticle = new ArrayList<>();
    }
    
    public Category(int nbCategory, String wording) {
    	this();
    	this.setNbCategory(nbCategory);
    	this.setWording(wording);
    }
    
    public int getNbCategory() {
    	return nbCategory;
    }
    
    public void setNbCategory(int nbCategory) {
		this.nbCategory = nbCategory;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public List<Article> getListArticle() {
		return listArticle;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + nbCategory + ", libelle=" + wording + "]";
	} 

}