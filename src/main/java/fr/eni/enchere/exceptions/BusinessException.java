/**
 * 
 */
package fr.eni.enchere.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
* Classe en charge de recenser l'ensemble des erreurs (par leur code) pouvant survenir lors d'un traitement quel que soit la couche à l'origine.
* @author lucasonandi93
* @date 9 janv. 2023 - 14:34:09
* @version ENI_Encheres - v0.1
*/
public class BusinessException extends Exception{

	private static final long serialVersionUID = -2594114105677499881L;
	private List<Integer> listErrorCodes;
	
	/**
	 * Constructeur
	 */
	public BusinessException() {
		super();
		//Initialisation de la liste et instanciation d'un ArrayList
		this.listErrorCodes=new ArrayList<>();
	}

	/**
	 * Méthode qui permet d'ajouter une erreur à la liste d'erreurs rencontrer lors de l'action en cours
	 * @param code
	 */
	public void addError(int code) {
		//Si la liste ne contient pas le code passé en paramètre, alors le code est ajouté à la liste
		if(!this.listErrorCodes.contains(code))
		{
			this.listErrorCodes.add(code);
		}
	}
	
	/**
	 * Méthode qui permet de savoir si l'application à rencontrée une erreur (si la liste d'erreur contient un code ou non)
	 * @return
	 */
	public boolean hasErrors() {
		return !this.listErrorCodes.isEmpty();
	}

	/**
	 * Getter pour listErrorCodes
	 * @return the listErrorCodes
	 */
	public List<Integer> getListErrorCodes() {
		return listErrorCodes;
	}
}
