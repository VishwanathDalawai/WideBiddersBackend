package com.widebidders.models.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void sendEmail(String mailId, String messageToBeSent, String subject){
		final String username = "widebidders2019@gmail.com";
    final String password = "Vishwanath@123";

    
    Properties prop = new Properties();

    prop.put("mail", "mail");
	prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); //TLS
    
    Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
    
    try{

    	MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("Widebidders@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(mailId)
        );
        message.setSubject("Hello User, from Widebidders!");
        message.setText(messageToBeSent);

        Transport.send(message);

        System.out.println("Done");

    }catch(MessagingException e) {
        e.printStackTrace();
    }
  }
}