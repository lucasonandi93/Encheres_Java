package fr.eni.enchere.dal.jdbc;

// normalement, on n'écrit pas les erreurs dans la console mais dans un fichier log

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
	/**
	 * Echec de la lecture des listes d'enchères
	 */
	public static final int LECTURE_LISTES_ECHEC=10002;
	
	/**
	 * Echec de la lecture d'une liste d'enchères
	 */
	public static final int LECTURE_LISTE_ECHEC=10003;
	/**
	 * liste d'enchères inexistante
	 */
	public static final int LECTURE_LISTE_INEXISTANTE=10004;
	
	/**
	 * Echec à la suppression d'un article
	 */
	public static final int SUPPRESSION_ARTICLE_ERREUR=10005;
	
	/**
	 * Echec à la suppression d'une liste
	 */
	public static final int SUPPRESSION_LISTE_ERREUR=10006;
	
}