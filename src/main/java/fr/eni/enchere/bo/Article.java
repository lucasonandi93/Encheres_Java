package fr.eni.enchere.bo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
* POJO Article
* @author ldupont2022
* @date 10 janv. 2023 - 10:16:02
* @version ENI_Encheres - v0.1
*/
public class Article implements Serializable{
	
	private static final long serialVersionUID = 7478601074654648439L;
	private int noArticle;
	private String nameArticle;
	private String description;
	private LocalDate auctionStartDate;
	private LocalDate auctionEndDate;
	private int originalPrice;
	private int sellingPrice;
	private String saleStatus;
	private User User;
	private int noCategory;
	private Withdrawal withdrawal;
	private List<Auction> listAuction;
	
	/**
	 * Constructeur
	 */
	public Article() {
		this.setOriginalPrice(0);
		this.setSellingPrice(0);
		this.listAuction = new ArrayList<>();
	}
	
	/**
	 * Constructeur
	 * @param nameArticle
	 * @param description
	 * @param auctionStartDate
	 * @param auctionEndDate
	 * @param noUser
	 * @param noCategory
	 */
	public Article(String nameArticle, String description, LocalDate auctionStartDate, LocalDate auctionEndDate, User user, int noCategory) {
		this();
		this.setNameArticle(nameArticle);
		this.setDescription(description);
		this.setAuctionStartDate(auctionStartDate);
		this.setAuctionEndDate(auctionEndDate);
		this.setUser(user);
		this.setNoCategory(noCategory);
	}
	
	/**
	 * Constructeur
	 * @param nameArticle
	 * @param description
	 * @param auctionStartDate
	 * @param auctionEndDate
	 * @param noUser
	 * @param noCategory
	 * @param withdrawal
	 */
	public Article(String nameArticle, String description, LocalDate auctionStartDate, LocalDate auctionEndDate, User user, int noCategory,  Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, user, noCategory);
		this.setWithdrawal(withdrawal);
	}
	
	/**
	 * Constructeur
	 * @param nameArticle
	 * @param description
	 * @param auctionStartDate
	 * @param auctionEndDate
	 * @param originalPrice
	 * @param noUser
	 * @param noCategory
	 */
	public Article(String nameArticle, String description, LocalDate auctionStartDate, LocalDate auctionEndDate,int originalPrice, User user, int noCategory) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, user, noCategory);
		this.setOriginalPrice(originalPrice);
	}
	
	/**
	 * Constructeur
	 * @param nameArticle
	 * @param description
	 * @param auctionStartDate
	 * @param auctionEndDate
	 * @param originalPrice
	 * @param noUser
	 * @param noCategory
	 * @param withdrawal
	 */
	public Article(String nameArticle, String description, LocalDate auctionStartDate, LocalDate auctionEndDate,int originalPrice, User user, int noCategory, Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, user, noCategory, withdrawal);
		this.setOriginalPrice(originalPrice);
	}
	
	/**
	 * Constructeur
	 * @param nameArticle
	 * @param description
	 * @param auctionStartDate
	 * @param auctionEndDate
	 * @param originalPrice
	 * @param sellingPrice
	 * @param noUser
	 * @param noCategory
	 */
	public Article(String nameArticle, String description, LocalDate auctionStartDate, LocalDate auctionEndDate,int originalPrice,int sellingPrice, User user, int noCategory) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, originalPrice, user, noCategory);
		this.setSellingPrice(sellingPrice);
	}
	
	/**
	 * Constructeur
	 * @param nameArticle
	 * @param description
	 * @param auctionStartDate
	 * @param auctionEndDate
	 * @param originalPrice
	 * @param sellingPrice
	 * @param noUser
	 * @param noCategory
	 * @param withdrawal
	 */
	public Article(String nameArticle, String description, LocalDate auctionStartDate, LocalDate auctionEndDate,int originalPrice,int sellingPrice, User user, int noCategory, Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, originalPrice, user, noCategory, withdrawal);
		this.setSellingPrice(sellingPrice);
	}
	
	/**
	 * Constructeur
	 * @param noArticle
	 * @param nameArticle
	 * @param description
	 * @param auctionStartDate
	 * @param auctionEndDate
	 * @param noUser
	 * @param noCategory
	 * @param withdrawal
	 */
	public Article(int noArticle, String nameArticle, String description, LocalDate auctionStartDate, LocalDate auctionEndDate, User user, int noCategory, Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, user, noCategory, withdrawal);
		this.setNoArticle(noArticle);
	}
	
	/**
	 * Constructeur
	 * @param noArticle
	 * @param nameArticle
	 * @param description
	 * @param auctionStartDate
	 * @param auctionEndDate
	 * @param originalPrice
	 * @param noUser
	 * @param noCategory
	 * @param withdrawal
	 */
	public Article(int noArticle, String nameArticle, String description, LocalDate auctionStartDate, LocalDate auctionEndDate,int originalPrice, User user, int noCategory, Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, originalPrice, user, noCategory, withdrawal);
		this.setNoArticle(noArticle);
	}
	
	/**
	 * Constructeur
	 * @param noArticle
	 * @param nameArticle
	 * @param description
	 * @param auctionStartDate
	 * @param auctionEndDate
	 * @param originalPrice
	 * @param sellingPrice
	 * @param noUser
	 * @param noCategory
	 */
	public Article(int noArticle, String nameArticle, String description, LocalDate auctionStartDate, LocalDate auctionEndDate,int originalPrice,int sellingPrice, User user, int noCategory) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, originalPrice, sellingPrice, user, noCategory);
		this.setNoArticle(noArticle);
	}
	
	/**
	 * Constructeur
	 * @param noArticle
	 * @param nameArticle
	 * @param description
	 * @param auctionStartDate
	 * @param auctionEndDate
	 * @param originalPrice
	 * @param sellingPrice
	 * @param noUser
	 * @param noCategory
	 * @param withdrawal
	 */
	public Article(int noArticle, String nameArticle, String description, LocalDate auctionStartDate, LocalDate auctionEndDate,int originalPrice,int sellingPrice, User user, int noCategory, Withdrawal withdrawal) {
		this(nameArticle, description, auctionStartDate, auctionEndDate, originalPrice, sellingPrice, user, noCategory, withdrawal);
		this.setNoArticle(noArticle);
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
	 * Getter pour nameArticle
	 * @return the nameArticle
	 */
	public String getNameArticle() {
		return nameArticle;
	}

	/**
	 * Setter pour nameArticle
	 * @param nameArticle the nameArticle to set
	 */
	public void setNameArticle(String nameArticle) {
		this.nameArticle = nameArticle;
	}

	/**
	 * Getter pour description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Getter pour user.
	 * @return the user
	 */
	public User getUser() {
		return User;
	}

	/**
	 * Setter pour user
	 * @param user the user to set
	 */
	public void setUser(User user) {
		User = user;
	}

	/**
	 * Setter pour description
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter pour auctionStartDate
	 * @return the auctionStartDate
	 */
	public LocalDate getAuctionStartDate() {
		return auctionStartDate;
	}

	/**
	 * Setter pour auctionStartDate
	 * @param auctionStartDate the auctionStartDate to set
	 */
	public void setAuctionStartDate(LocalDate auctionStartDate) {
		this.auctionStartDate = auctionStartDate;
	}

	/**
	 * Getter pour auctionEndDate
	 * @return the auctionEndDate
	 */
	public LocalDate getAuctionEndDate() {
		return auctionEndDate;
	}

	/**
	 * Setter pour auctionEndDate
	 * @param auctionEndDate the auctionEndDate to set
	 */
	public void setAuctionEndDate(LocalDate auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}

	/**
	 * Getter pour originalPrice
	 * @return the originalPrice
	 */
	public int getOriginalPrice() {
		return originalPrice;
	}

	/**
	 * Setter pour originalPrice
	 * @param originalPrice the originalPrice to set
	 */
	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	/**
	 * Getter pour sellingPrice
	 * @return the sellingPrice
	 */
	public int getSellingPrice() {
		return sellingPrice;
	}

	/**
	 * Setter pour sellingPrice
	 * @param sellingPrice the sellingPrice to set
	 */
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	/**
	 * Getter pour saleStatus
	 * @return the saleStatus
	 */
	public String getSaleStatus() {
		return saleStatus;
	}

	/**
	 * Setter pour saleStatus
	 * @param saleStatus the saleStatus to set
	 */
	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
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
	public void setNoCategory(int noCategory) {
		this.noCategory = noCategory;
	}

	/**
	 * Getter pour withdrawal
	 * @return the withdrawal
	 */
	public Withdrawal getWithdrawal() {
		return withdrawal;
	}

	/**
	 * Setter pour withdrawal
	 * @param withdrawal the withdrawal to set
	 */
	public void setWithdrawal(Withdrawal withdrawal) {
		this.withdrawal = withdrawal;
	}

	/**
	 * Getter pour listAuction
	 * @return the listAuction
	 */
	public List<Auction> getListAuction() {
		return listAuction;
	}

	
	/**
	 * Méthode qui permet d'afficher l'Article
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" - Article [getNoArticle()=");
		builder.append(getNoArticle());
		builder.append(", getNameArticle()=");
		builder.append(getNameArticle());
		builder.append(", getDescription()=");
		builder.append(getDescription());
		builder.append(", getAuctionStartDate()=");
		builder.append(getAuctionStartDate());
		builder.append(", getAuctionEndDate()=");
		builder.append(getAuctionEndDate());
		builder.append(", getOriginalPrice()=");
		builder.append(getOriginalPrice());
		builder.append(", getSellingPrice()=");
		builder.append(getSellingPrice());
		builder.append(", getSaleStatus()=");
		builder.append(getSaleStatus());
		builder.append(", getUser()=");
		builder.append(getUser());
		builder.append(", getNoCategory()=");
		builder.append(getNoCategory());
		builder.append("\n");
		builder.append("Withdrawal=");
		builder.append(getWithdrawal());
		builder.append("\n");
		builder.append("ListAuction=");
		
		for (Auction auction : this.getListAuction()) {
			builder.append("\n");
			builder.append(auction);
		}
		
		builder.append("]");
		return builder.toString();
	}

	
} 