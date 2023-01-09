package fr.eni.enchere.bo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Article implements Serializable{
	
	private static final long serialVersionUID = 7478601074654648439L;
	private int noArticle;
	private String nameArticle;
	private String description;
	private Date auctionStartDate;
	private Date auctionEndDate;
	private int originalPrice;
	private int sellingPrice;
	private String saleStatus;
	private int noUser;
	private int noCategory;
	private List<Article> articleList;
	private List<Article> auctionList;
	private Withdrawal withdrawal;
	
	public Article() {
		
	}
	
	 public Article(int nbArticle,
             String nameArticle,
             String description,
             Date auctionStartDate,
             Date auctionEndDate,
             int originalPrice,
             int sellingPrice,
             String saleStatus,
             int nbUser,
             int nbCategory) {
				this.setNbArticle(nbArticle);
				this.setNameArticle(nameArticle);
				this.setDescription(description);
				this.setAuctionStartDate(auctionStartDate);
				this.setAuctionEndDate(auctionEndDate);
				this.setOriginalPrice(originalPrice);
				this.setSellingPrice(sellingPrice);
				this.setSaleStatus(saleStatus);
				this.setNbUser(nbUser);
				this.setNbCategory(nbCategory);
}
	
	 public Article(String nameArticle,
             String description,
             Date auctionStartDate,
             Date auctionEndDate,
             int originalPrice,
             int sellingPrice,
             String saleStatus,
             int nbUser,
             int nbCategory) {
		 	this.setNameArticle(nameArticle);
			this.setDescription(description);
			this.setAuctionStartDate(auctionStartDate);
			this.setAuctionEndDate(auctionEndDate);
			this.setOriginalPrice(originalPrice);
			this.setSellingPrice(sellingPrice);
			this.setSaleStatus(saleStatus);
			this.setNbUser(nbUser);
			this.setNbCategory(nbCategory);
}

	public int getNbArticle() {
		return noArticle;
	}

	public void setNbArticle(int nbArticle) {
		this.noArticle = nbArticle;
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
		return noUser;
	}

	public void setNbUser(int nbUser) {
		this.noUser = nbUser;
	}

	public int getNbCategory() {
		return noCategory;
	}

	public void setNbCategory(int nbCategory) {
		this.noCategory = nbCategory;
	}
	 @Override
	    public String toString() {
	        return "ArticleVendu{" +
	                "noArticle=" + noArticle +
	                ", nomArticle='" + nameArticle + '\'' +
	                ", description='" + description + '\'' +
	                ", dateDebutEncheres=" + auctionStartDate +
	                ", dateFinEncheres=" + auctionEndDate +
	                ", prixInitial=" + originalPrice +
	                ", prixVente=" + sellingPrice +
	                ", etatVente='" + saleStatus + '\'' +
	                ", noUtilisateur=" + noUser +
	                ", noCategorie=" + noCategory +
	                '}';
	 }

	public Withdrawal getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(Withdrawal withdrawal) {
		this.withdrawal = withdrawal;
	}
} 