package com.formation.projetNavette.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
	
	public static void envoiMail(String mail) {

	
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("teamcinqaelion@gmail.com","Azertyuiop12");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@no-spam.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mail));
			message.setSubject("Confirmation de votre reservation NavetteAirport");
			message.setText("Bonjour," +
					"\n\n Confirmation de votre reservation pour la navette" + "\n\n Cordialement l'équipe team Cinq");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public static void envoiMailAnnulation(String mail) {

		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("teamcinqaelion@gmail.com","Azertyuiop12");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@no-spam.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mail));
			message.setSubject("Annulation de votre Navette Airport");
			message.setText("Bonjour," +
					"\n\n Annulation de votre reservation pour la navette" + "\n\n Cordialement l'équipe team Cinq");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	}



