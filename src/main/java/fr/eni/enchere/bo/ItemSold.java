package fr.eni.enchere.bo;
import java.util.Date;

public class ItemSold {
	private int nbArticle;
	private String nameArticle;
	private String description;
	private Date auctionStartDate;
	private Date auctionEndDate;
	private int originalPrice;
	private int sellingPrice;
	private String saleStatus;
	private int nbUser;
	private int nbCategory;
	
	public ItemSold() {
		
	}
	
	 public ItemSold(int nbArticle,
             String nameArticle,
             String description,
             Date auctionStartDate,
             Date auctionEndDate,
             int originalPrice,
             int sellingPrice,
             String saleStatus,
             int nbUser,
             int nbCategory) {
this.nbArticle = nbArticle;
this.nameArticle = nameArticle;
this.description = description;
this.auctionStartDate = auctionStartDate;
this.auctionEndDate = auctionEndDate;
this.originalPrice = originalPrice;
this.sellingPrice = sellingPrice;
this.saleStatus = saleStatus;
this.nbUser = nbUser;
this.nbCategory = nbCategory;
}
	
	 public ItemSold(String nameArticle,
             String description,
             Date auctionStartDate,
             Date auctionEndDate,
             int originalPrice,
             int sellingPrice,
             String saleStatus,
             int nbUser,
             int nbCategory) {
this.nameArticle = nameArticle;
this.description = description;
this.auctionStartDate = auctionStartDate;
this.auctionEndDate = auctionEndDate;
this.originalPrice = originalPrice;
this.sellingPrice = sellingPrice;
this.saleStatus = saleStatus;
this.nbUser = nbUser;
this.nbCategory = nbCategory;
}

	public int getNbArticle() {
		return nbArticle;
	}

	public void setNbArticle(int nbArticle) {
		this.nbArticle = nbArticle;
	}

	public String getNameArticle() {
		return nameArticle;
	}

	public void setNameArticle(String nameArticle) {
		this.nameArticle = nameArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getAuctionStartDate() {
		return auctionStartDate;
	}

	public void setAuctionStartDate(Date auctionStartDate) {
		this.auctionStartDate = auctionStartDate;
	}

	public Date getAuctionEndDate() {
		return auctionEndDate;
	}

	public void setAuctionEndDate(Date auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}

	public int getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}

	public int getNbUser() {
		return nbUser;
	}

	public void setNbUser(int nbUser) {
		this.nbUser = nbUser;
	}

	public int getNbCategory() {
		return nbCategory;
	}

	public void setNbCategory(int nbCategory) {
		this.nbCategory = nbCategory;
	}
	 @Override
	    public String toString() {
	        return "ArticleVendu{" +
	                "noArticle=" + nbArticle +
	                ", nomArticle='" + nameArticle + '\'' +
	                ", description='" + description + '\'' +
	                ", dateDebutEncheres=" + auctionStartDate +
	                ", dateFinEncheres=" + auctionEndDate +
	                ", prixInitial=" + originalPrice +
	                ", prixVente=" + sellingPrice +
	                ", etatVente='" + saleStatus + '\'' +
	                ", noUtilisateur=" + nbUser +
	                ", noCategorie=" + nbCategory +
	                '}';
	 }
}

