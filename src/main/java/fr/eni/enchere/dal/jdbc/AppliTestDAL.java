package fr.eni.enchere.dal.jdbc;

import java.time.LocalDate;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.bo.Withdrawal;

/**
* Classe en charge de tester la DAL
* @author ldupont2022
* @date 10 janv. 2023 - 08:44:16
* @version ENI_Encheres - v0.1
*/
public class AppliTestDAL {

	/**
	 * Méthode qui permet de faire des tests sur la couche DAL
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		User alex = new User("Masque_Panda", "Boulay", "Alexandre", "alex.boulay@orange.fr", "07-85-66-90-96", "rue de la foret", "53540", "LAUBRIERES", "quiqui35", 1000, false);
		User luca = new User("Iromega", "Dupont", "Luca", "leboss@gmail.com", "02 90 66 55 22", "rue du pendu", "35500", "VITRE", "bidon25", 250, false);
		User alban = new User("Ferach", "Ferrera", "Alban", "banban.ferach@orange.fr", "06 52 33 29 52", "rue des perdus", "85600", "AMIENS", "leclown", 3000, true);
		
		Auction auction1 = new Auction(LocalDate.of(2023, 0, 0),200,1,2);
		Auction auction2 = new Auction(LocalDate.of(2023, 0, 0),100,1,5);
		Auction auction3 = new Auction(LocalDate.of(2023, 0, 0),50,2,4);
		Auction auction4 = new Auction(LocalDate.of(2023, 0, 0),1000,2,3);
		Auction auction5 = new Auction(LocalDate.of(2023, 0, 0),10,3,1);

		Withdrawal withdrawal = new Withdrawal(1, "rue de la foret", "53540", "LAUBRIERES");
		Withdrawal withdrawa2 = new Withdrawal(2, "rue du pendu", "35500", "VITRE");
		Withdrawal withdrawa3 = new Withdrawal(3, "rue des perdus", "85600", "AMIENS");
		Withdrawal withdrawa4 = new Withdrawal(4, "rue de la foret", "53540", "LAUBRIERES");
		Withdrawal withdrawa5 = new Withdrawal(5, "rue de la foret", "53540", "LAUBRIERES");
		
		Article pcGamer = new Article("PC Gamer 3000", "Un super PC fixe avec de grosses performances", LocalDate.of(2023, 01, 20), LocalDate.of(2023, 02, 01), 1, 1, withdrawal);
		Article table = new Article("Table Ronde", "Une table ronde qui fait un mêtre de haut", LocalDate.of(2023, 02, 20), LocalDate.of(2023, 02, 25), 2, 2, withdrawa2);
		Article ballon = new Article("Ballon de foot", "Ballon de l'équipe de france signé par tous les joueurs", LocalDate.of(2023, 01, 25), LocalDate.of(2023, 02, 03), 3, 4, withdrawa3);
		Article slip = new Article("Slip sale", "Un slip avec une grosse trace de pneu", LocalDate.of(2023, 01, 29), LocalDate.of(2023, 03, 02), 1, 3, withdrawa4);
		Article souris = new Article("Souris sans file", "Une souris sans file (Connection Bluetooth)", LocalDate.of(2023, 03, 10), LocalDate.of(2023, 03, 11), 2, 1, withdrawa5);
	}

}
