/**
 * 
 */
package fr.eni.enchere.messages;

import java.io.Serializable;
import java.util.ResourceBundle;

/**
* Classe en charge de lire les messages d'erreurs correspondant aux codes
* @author ldupont2022
* @date 9 janv. 2023 - 14:50:52
* @version ENI_Encheres - v0.1
*/
public class MessageReader implements Serializable{

	private static final long serialVersionUID = 677221689287863636L;
	private static ResourceBundle rb;
	
	static
	{
		try
		{
			rb = ResourceBundle.getBundle("fr.eni.enchere.messages.messages_erreur");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode qui permet de récupérer le message d'erreur grace à son code
	 * @param code
	 * @return
	 */
	public static String getErrorMessage(int code) {
		String message="";
		try
		{
			if(rb!=null)
			{
				message = rb.getString(String.valueOf(code));
			}
			else
			{
				message="Problème à la lecture du fichier contenant les messages";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			message="Une erreur inconnue est survenue";
		}
		return message;
	}

}
