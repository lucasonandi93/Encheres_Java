package fr.eni.enchere.bo;
import java.io.Serializable;
import java.util.ArrayList;
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
	private Withdrawal withdrawal;
	private List<Auction> listAuction;
	
	public Article() {
		this.setOriginalPrice(0);
		this.setSellingPrice(0);
		this.listAuction = new ArrayList<>();
	}
	
	public Article(String nameArticle, String description, Date auctionStartDate, Date auctionEndDate, int noUser, int noCategory,  Withdrawal withdrawal) {
		this();
		this.setNameArticle(nameArticle);
		this.setDescription(description);
		this.setAuctionStartDate(auctionStartDate);
		this.setAuctionEndDate(auctionEndDate);
		this.setNoUser(noUser);
		this.setNoCategory(noCategory);
		this.setWithdrawal(withdrawal);
	}
	
	public Article(String nameArticle, String description, Date auctionStartDate, Date auctionEndDate,int originalPrice, int noUser, int noCategory, Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, noUser, noCategory, withdrawal);
		this.setOriginalPrice(originalPrice);
	}
	
	public Article(String nameArticle, String description, Date auctionStartDate, Date auctionEndDate,int originalPrice,int sellingPrice, int noUser, int noCategory, Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, originalPrice, noUser, noCategory, withdrawal);
		this.setSellingPrice(sellingPrice);
	}
	
	public Article(int noArticle, String nameArticle, String description, Date auctionStartDate, Date auctionEndDate, int noUser, int noCategory, Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, noUser, noCategory, withdrawal);
		this.setNoArticle(noArticle);
	}
	
	public Article(int noArticle, String nameArticle, String description, Date auctionStartDate, Date auctionEndDate,int originalPrice, int noUser, int noCategory, Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, originalPrice, noUser, noCategory, withdrawal);
		this.setNoArticle(noArticle);
	}
	
	public Article(int noArticle, String nameArticle, String description, Date auctionStartDate, Date auctionEndDate,int originalPrice,int sellingPrice, int noUser, int noCategory, Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, originalPrice, sellingPrice, noUser, noCategory, withdrawal);
		this.setNoArticle(noArticle);
	}
	
	
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int nbArticle) {
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

	public int getNoUser() {
		return noUser;
	}

	public void setNoUser(int nbUser) {
		this.noUser = nbUser;
	}

	public int getNoCategory() {
		return noCategory;
	}

	public void setNoCategory(int nbCategory) {
		this.noCategory = nbCategory;
	}
	
	public Withdrawal getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(Withdrawal withdrawal) {
		this.withdrawal = withdrawal;
	}
	
	 public List<Auction> getListAuction() {
		return listAuction;
	}

	@Override
	public String toString() {
		return "Article [getNoArticle()=" + getNoArticle() + ", getNameArticle()=" + getNameArticle()
				+ ", getDescription()=" + getDescription() + ", getAuctionStartDate()=" + getAuctionStartDate()
				+ ", getAuctionEndDate()=" + getAuctionEndDate() + ", getOriginalPrice()=" + getOriginalPrice()
				+ ", getSellingPrice()=" + getSellingPrice() + ", getSaleStatus()=" + getSaleStatus() + ", getNoUser()="
				+ getNoUser() + ", getNoCategory()=" + getNoCategory() + ", getWithdrawal()=" + getWithdrawal()
				+ ", getListAuction()=" + getListAuction() + "]";
	}
} 