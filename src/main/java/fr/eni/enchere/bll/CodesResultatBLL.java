/**
 * 
 */
package fr.eni.enchere.bll;

/**
* Classe en charge d'attribuer un code à une erreur
* @author ldupont2022
* @date 9 janv. 2023 - 15:37:37
* @version ENI_Encheres - v0.1
*/
public abstract class CodesResultatBLL {
	
	//BLL USER ERRORS
	public static final int RULE_USER_PSEUDO_ERROR=20000;
	
	public static final int RULE_USER_NAME_ERROR=20001;
	
	public static final int RULE_USER_FIRSTNAME_ERROR=20002;
	
	public static final int RULE_USER_EMAIL_ERROR=20003;
	
	public static final int RULE_USER_STREET_ERROR=20004;
	
	public static final int RULE_USER_CP_ERROR=20005;
	
	public static final int RULE_USER_CITY_ERROR=20006;
	
	public static final int RULE_USER_PASSWORD_ERROR=20007;
	
	public static final int RULE_ARTICLE_WITHDRAWAL_ERROR=20008;
	
	public static final int RULE_USER_PHONE_ERROR=20009;
	
	//BLL ARTICLE ERRORS
	public static final int RULE_ARTICLE_NAME_ERROR=20010;
	
	public static final int RULE_ARTICLE_DECRIPTION_ERROR=20011;
	
	public static final int RULE_ARTICLE_START_DATE_ERROR=20012;
	
	public static final int RULE_ARTICLE_END_DATE_ERROR=20013;
	
	public static final int RULE_ARTICLE_USER_ERROR=20014;
	
	public static final int RULE_ARTICLE_NO_CATEGORY_ERROR=20015;
	
	//BLL AUCTION ERRORS
	public static final int	RULE_AUCTION_NO_USER_ERROR=20020;
	
	public static final int RULE_AUCTION_NO_ARTICLE_ERROR=20021;
	
	public static final int RULE_AUCTION_AMOUNT_ERROR=20022;
	
	

}
