package fr.eni.enchere.bo;
import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = -2579992292596511238L;
	private int     nbUser;
    private String  pseudo;
    private String  name;
    private String  firstName;
    private String  email;
    private String  phone;
    private String  street;
    private String  cp;
    private String  city;
    private String  password;
    private int     credit;
    private boolean administrator;
    List<Article> articleList;
    List<Article> auctionList;
    /**
     * Empty constructor
     */
    public User() {
    }

    public User(String pseudo,
            String name,
            String firstName,
            String email,
            String phone,
            String street,
            String cp,
            String city,
            String password,
            int credit,
            boolean administrator) {

this.setPseudo(pseudo);
this.setName(name);
this.setFirstName(firstName);
this.setEmail(email);
this.setPhone(phone);
this.setStreet(street);
this.setCp(cp);
this.setCity(city);
this.setPassword(password);
this.setCredit(credit);
this.setAdministrator(administrator);
}
    
    public User(int nbUser,
            String pseudo,
            String name,
            String firstName,
            String email,
            String phone,
            String street,
            String cp,
            String city,
            String password,
            int credit,
            boolean administrator) {
    	
			this.setNbUser(nbUser);
			this.setPseudo(pseudo);
			this.setName(name);
			this.setFirstName(firstName);
			this.setEmail(email);
			this.setPhone(phone);
			this.setStreet(street);
			this.setCp(cp);
			this.setCity(city);
			this.setPassword(password);
			this.setCredit(credit);
			this.setAdministrator(administrator);
}
    
    public int getNbUser() {
        return nbUser;
    }

    public void setNbUser(int nbUser) {
        this.nbUser = nbUser;
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
    
    @Override
    public String toString() {
        return "Utilisateur{" +
                "noUtilisateur=" + nbUser +
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