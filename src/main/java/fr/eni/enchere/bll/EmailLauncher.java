package fr.eni.enchere.bll;

import fr.eni.enchere.servlet.Email;

public class EmailLauncher {
 public static void main(String[] args) {
	 Email.send(
			    "sitedenchere35@gmail.com",
			    "kbqjnczzjxqpqbhi",
			    "sitedenchere35@gmail.com",
			    "Votre mot de passe :",
			    "mail de test!"
			  );
}
}
