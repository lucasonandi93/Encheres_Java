package fr.eni.enchere.servlet;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
    public static void send(String from, String pwd, String to, String sub, String msg) {
        // Propriétés
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS
        // Session
        Session s = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pwd);
            }
        });
        // Composer le message
        try {
            MimeMessage m = new MimeMessage(s);
            m.setFrom(new InternetAddress(from));
            m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(sub);
            m.setText(msg);
            // Envoyer le message
            Transport.send(m);
            System.out.println("Message envoyé avec succès");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
