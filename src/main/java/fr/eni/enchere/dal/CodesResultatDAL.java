package fr.eni.enchere.dal;

// normalement, on n'écrit pas les erreurs dans la console mais dans un fichier log

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	// ERROR_USER
	public static final int SELECT_LIST_USER_FAILED=10000;
	
	public static final int SELECT_USER_ID_FAILED=10001;
	
	public static final int INSERT_USER_FAILED=10002;
	
	public static final int	UPDATE_USER_FAILED=10003;
	
	public static final int DELETE_USER_FAILED=10004;
	
	public static final int SELECT_USER_PSEUDO_MDP_FAILED=10005;
	
	public static final int INSERT_PSEUDO_MDP_USER_NULL=10007;
	
	public static final int INSERT_USER_NULL=10008;
	
	public static final int INSERT_ID_USER_NULL=10009;
	
	//ERROR_ARTICLE
	public static final int SELECT_LIST_ARTICLE_FAILED=10010;
	
	public static final int SELECT_ARTICLE_ID_FAILED=10011;
	
	public static final int INSERT_ARTICLE_FAILED=10012;
	
	public static final int	UPDATE_ARTICLE_FAILED=10013;
	
	public static final int DELETE_ARTICLE_FAILED=10014;
	
	public static final int INSERT_ARTICLE_TO_WITHDRAWAL_FAILED=10015;

	public static final int INSERT_ARTICLE_NULL=10016;
	
	public static final int INSERT_ID_ARTICLE_NULL=10017;
	
	public static final int SELECT_ARTICLE_CATEGORY_FAILED=10018;
	
	public static final int INSERT_STRING_NULL=10019;
	
	//ERROR_AUCTION
	public static final int SELECT_LIST_AUCTION_FAILED=10020;
	
	public static final int SELECT_AUCTION_ID_FAILED=10021;
	
	public static final int INSERT_AUCTION_FAILED=10022;
	
	public static final int UPDATE_AUCTION_FAILED=10023;
	
	public static final int DELETE_AUCTION_FAILED=10024;
	
	public static final int INSERT_AUCTION_NULL=10028;
			
	public static final int INSERT_ID_AUCTION_NULL=10029;
	
	//ERROR CATEGORY
	public static final int SELECT_LIST_CATEGORY_FAILED=10030;
	
	public static final int SELECT_CATEGORY_ID_FAILED=10031;
	
}