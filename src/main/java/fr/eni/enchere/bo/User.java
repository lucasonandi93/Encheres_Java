package fr.eni.enchere.bo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
     * Empty constructor
     */
    public User() {
    	this.articleList = new ArrayList<>();
    	this.auctionList = new ArrayList<>();
    	this.setCredit(0);
    	this.setAdministrator(false);
    }
    

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
    
    
    public User(String pseudo, String name, String firstName, String email, String phone, String street, String cp, String city, String password) {
		this(pseudo, name, firstName, email, street, cp, city, password);
		this.setPhone(phone);
	}
    
    public User(String pseudo, String name, String firstName, String email, String phone, String street, String cp, String city, String password, int credit, boolean administrator) {
		this(pseudo, name, firstName, email, phone, street, cp, city, password);
		this.setCredit(credit);
		this.setAdministrator(administrator);
	}
    
    public User(int noUser, String pseudo, String name, String firstName, String email, String street, String cp, String city, String password) {
		this(pseudo, name, firstName, email, street, cp, city, password);
		this.setNoUser(noUser);
	}
    
    public User(int noUser, String pseudo, String name, String firstName, String email, String phone, String street, String cp, String city, String password) {
		this(pseudo, name, firstName, email, phone, street, cp, city, password);
		this.setNoUser(noUser);
	}
    
    public User(int noUser, String pseudo, String name, String firstName, String email, String phone, String street, String cp, String city, String password, int credit, boolean administrator) {
		this(pseudo, name, firstName, email, phone, street, cp, city, password, credit, administrator);
		this.setNoUser(noUser);
	}
    
    
    public int getNoUser() {
        return noUser;
    }

    public void setNoUser(int nbUser) {
        this.noUser = nbUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
    
    
    public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public List<Auction> getAuctionList() {
		return auctionList;
	}

	public void setAuctionList(List<Auction> auctionList) {
		this.auctionList = auctionList;
	}

	@Override
    public String toString() {
        return "Utilisateur{" +
                "noUtilisateur=" + noUser +
                ", pseudo='" + pseudo + '\'' +
                ", nom='" + name + '\'' +
                ", prenom='" + firstName+ '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + phone + '\'' +
                ", rue='" + street + '\'' +
                ", codePostal='" + cp + '\'' +
                ", ville='" + city + '\'' +
                ", motDePasse='" + password + '\'' +
                ", credit=" + credit +
                ", administrateur=" + administrator +
                '}';
    }
} 