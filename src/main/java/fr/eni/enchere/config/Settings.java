package fr.eni.enchere.config;

import java.io.IOException;
import java.util.Properties;

/**
* Classe en charge de récupérer les différentes congiguration d'implémentation
* @author lucasonandi93
* @date 19 janv. 2023 - 09:37:11
* @version trocenchere - v0.1
*/
public class Settings {

	private static Properties properties;

	static {
		properties = new Properties();
		try {
			//Va chercher le fichier settings.properties du package config
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Méthode qui permet de récupérer une implémentation
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key, null);
		
	}
	
}
