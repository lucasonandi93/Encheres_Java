package fr.eni.enchere.bo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* POJO User
* @author lucasonandi93
* @date 10 janv. 2023 - 10:41:16
* @version ENI_Encheres - v0.1
*/
public class User implements Serializable {

	private static final long serialVersionUID = -2579992292596511238L;
	private int noUser;
    private String pseudo;
    private String name;
    private String firstName;
    private String email;
    private String phone;
    private String street;
    private String cp;
    private String city;
    private String password;
    private int credit;
    private boolean administrator;
    private List<Article> articleList;
    private List<Auction> auctionList;
    
    /**
     * Constructeur
     */
    public User() {
    	this.articleList = new ArrayList<>();
    	this.auctionList = new ArrayList<>();
    	this.setCredit(0);
    	this.setAdministrator(false);
    }
    
    /**
     * Constructeur
     * @param pseudo
     * @param name
     * @param firstName
     * @param email
     * @param street
     * @param cp
     * @param city
     * @param password
     */
    public User(String pseudo, String name, String firstName, String email, String street, String cp, String city, String password) {
		this();
		this.setPseudo(pseudo);
		this.setName(name);
		this.setFirstName(firstName);
		this.setEmail(email);
		this.setStreet(street);
		this.setCp(cp);
		this.setCity(city);
		this.setPassword(password);
	}
    
    /**
     * Constructeur
     * @param pseudo
     * @param name
     * @param firstName
     * @param email
     * @param phone
     * @param street
     * @param cp
     * @param city
     * @param password
     */
    public User(String pseudo, String name, String firstName, String email, String phone, String street, String cp, String city, String password) {
		this(pseudo, name, firstName, email, street, cp, city, password);
		this.setPhone(phone);
	}
    
    /**
     * Constructeur
     * @param pseudo
     * @param name
     * @param firstName
     * @param email
     * @param phone
     * @param street
     * @param cp
     * @param city
     * @param password
     * @param credit
     * @param administrator
     */
    public User(String pseudo, String name, String firstName, String email, String phone, String street, String cp, String city, String password, int credit, boolean administrator) {
		this(pseudo, name, firstName, email, phone, street, cp, city, password);
		this.setCredit(credit);
		this.setAdministrator(administrator);
	
    }
    /**
     * Constructeur
     * @param noUser
     * @param pseudo
     * @param name
     * @param firstName
     * @param email
     * @param street
     * @param cp
     * @param city
     * @param password
     */
    public User(int noUser, String pseudo, String name, String firstName, String email, String street, String cp, String city, String password) {
		this(pseudo, name, firstName, email, street, cp, city, password);
		this.setNoUser(noUser);
	}
    
    /**
     * Constructeur
     * @param noUser
     * @param pseudo
     * @param name
     * @param firstName
     * @param email
     * @param phone
     * @param street
     * @param cp
     * @param city
     * @param password
     */
    public User(int noUser, String pseudo, String name, String firstName, String email, String phone, String street, String cp, String city, String password) {
		this(pseudo, name, firstName, email, phone, street, cp, city, password);
		this.setNoUser(noUser);
	}
    
    /**
     * Constructeur
     * @param noUser
     * @param pseudo
     * @param name
     * @param firstName
     * @param email
     * @param phone
     * @param street
     * @param cp
     * @param city
     * @param password
     * @param credit
     * @param administrator
     */
    public User(int noUser, String pseudo, String name, String firstName, String email, String phone, String street, String cp, String city, String password, int credit, boolean administrator) {
		this(pseudo, name, firstName, email, phone, street, cp, city, password, credit, administrator);
		this.setNoUser(noUser);
	}
    
	/**
	 * Constructeur
	 * @param int1
	 * @param string
	 * @param string2
	 * @param string3
	 * @param string4
	 * @param string5
	 * @param string6
	 * @param string7
	 * @param string8
	 * @param int2
	 * @param boolean1
	 */
	public User(int noUser, String pseudo, String name, String firstName, String email, String phone, String street,
			String cp, String city, int credit, boolean administrator) {
	}

	/**
	 * Getter pour noUser
	 * @return the noUser
	 */
	public int getNoUser() {
		return noUser;
	}

	/**
	 * Setter pour noUser
	 * @param noUser the noUser to set
	 */
	public void setNoUser(int noUser) {
		this.noUser = noUser;
	}

	/**
	 * Getter pour pseudo
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Setter pour pseudo
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Getter pour name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter pour name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter pour firstName
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter pour firstName
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter pour email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter pour email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter pour phone
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Setter pour phone
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * Getter pour password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter pour password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter pour credit
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * Setter pour credit
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
	 * Getter pour administrator
	 * @return the administrator
	 */
	public boolean isAdministrator() {
		return administrator;
	}

	/**
	 * Setter pour administrator
	 * @param administrator the administrator to set
	 */
	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	/**
	 * Getter pour articleList
	 * @return the articleList
	 */
	public List<Article> getArticleList() {
		return articleList;
	}

	/**
	 * Getter pour auctionList
	 * @return the auctionList
	 */
	public List<Auction> getAuctionList() {
		return auctionList;
	}

	
	/**
	 * Méthode qui permet d'afficher le User
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" - User [getNoUser()=");
		builder.append(getNoUser());
		builder.append(", getPseudo()=");
		builder.append(getPseudo());
		builder.append(", getName()=");
		builder.append(getName());
		builder.append(", getFirstName()=");
		builder.append(getFirstName());
		builder.append(", getEmail()=");
		builder.append(getEmail());
		builder.append(", getPhone()=");
		builder.append(getPhone());
		builder.append(", getStreet()=");
		builder.append(getStreet());
		builder.append(", getCp()=");
		builder.append(getCp());
		builder.append(", getCity()=");
		builder.append(getCity());
		builder.append(", getPassword()=");
		builder.append(getPassword());
		builder.append(", getCredit()=");
		builder.append(getCredit());
		builder.append(", isAdministrator()=");
		builder.append(isAdministrator());
		builder.append("]");
		return builder.toString();
	}

	
} 