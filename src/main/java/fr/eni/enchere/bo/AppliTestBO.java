package fr.eni.enchere.bo;
import java.time.LocalDate;
public class AppliTestBO {

	public static void main(String[] args) {
		
		Article article1 = new Article("PC Gamer 3000", "Un super PC fixe avec de grosses performances", LocalDate.now(), LocalDate.now(), new User(), new Category());
		Article article2 = new Article("name", "desc", LocalDate.now(), LocalDate.now(), 1, new User(), new Category(), new Withdrawal());
		Article article3 = new Article("name", "desc", LocalDate.now(), LocalDate.now(), 1, 1, new User(), new Category(), new Withdrawal());
		Article article4 = new Article( 1, "name", "desc", LocalDate.now(), LocalDate.now(),new User(), new Category(), new Withdrawal());
		Article article5 = new Article( 1, "name", "desc", LocalDate.now(), LocalDate.now(), 1, new User(), new Category(), new Withdrawal());
		Article article6 = new Article( 1, "name", "desc", LocalDate.now(), LocalDate.now(), 1, 1, new User(), new Category(), new Withdrawal());
		
		Auction auction = new Auction(1,new User(),new Article());
		
		Category category = new Category(1, "wording");
		
		User user1 = new User("pseudo", "name", "firstName", "email", "street", "cp", "city", "password");
		User user2 = new User("pseudo", "name", "firstName", "email", "phone", "street", "cp", "city", "password");
		User user3 = new User("pseudo", "name", "firstName", "email", "phone", "street", "cp", "city", "password", 1, true);
		User user4 = new User(1, "pseudo", "name", "firstName", "email", "street", "cp", "city", "password");
		User user5 = new User(1, "pseudo", "name", "firstName", "email", "phone", "street", "cp", "city", "password");
		User user6 = new User(1, "pseudo", "name", "firstName", "email", "phone", "street", "cp", "city", "password", 1, true);
		
		Withdrawal withdrawal = new Withdrawal(1, "street", "cp", "city");
		
		user1.getArticleList().add(article1);
		user1.getArticleList().add(article2);
		user1.getArticleList().add(article3);
		user1.getArticleList().add(article4);
		user1.getArticleList().add(article5);
		user1.getArticleList().add(article6);
		
		user1.getAuctionList().add(auction);
		
		article1.getListAuction().add(auction);
		
		
		System.out.println("=========================================================");
		System.out.println(article1);
		System.out.println("---------------------------------------------------------");
		System.out.println(article2);
		System.out.println("---------------------------------------------------------");
		System.out.println(article3);
		System.out.println("---------------------------------------------------------");
		System.out.println(article4);
		System.out.println("---------------------------------------------------------");
		System.out.println(article5);
		System.out.println("---------------------------------------------------------");
		System.out.println(article6);
		System.out.println("=========================================================");
		System.out.println(auction);
		System.out.println("=========================================================");
		System.out.println(category);
		System.out.println("=========================================================");
		System.out.println(user1);
		System.out.println("---------------------------------------------------------");
		System.out.println(user2);
		System.out.println("---------------------------------------------------------");
		System.out.println(user3);
		System.out.println("---------------------------------------------------------");
		System.out.println(user4);
		System.out.println("---------------------------------------------------------");
		System.out.println(user5);
		System.out.println("---------------------------------------------------------");
		System.out.println(user6);
		System.out.println("=========================================================");
		System.out.println(withdrawal);
		System.out.println("=========================================================");
	}
}
