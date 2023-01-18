package fr.eni.enchere.servlet;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	public static boolean send(String from, String pwd, String to, String sub, String msg) {
		// Propri�t�s
		Properties prop = new Properties();
		prop.put("mail.smtp.ssl.protocols","TLSv1.2");
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
		// Session
        
		Session s = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pwd);
			}
		});
		// composer le message
		try {
			MimeMessage m = new MimeMessage(s);
			m.setFrom(new InternetAddress(from));
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(sub);
			m.setText(msg);
			// envoyer le message
			Transport.send(m);
			System.out.println("Message envoyé avec succès");
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
