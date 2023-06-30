package com.nkxgen.spring.jdbc.validation;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class MailSenderImpl implements MailSender {
	public String send(String to_user) {
		String to = to_user; // Assign the value of the 'to_user' parameter to the 'to' variable
		String otp = generateOTP(); // Generate a random OTP
		String subject = "Password Reset"; // Set the email subject
		String body = "The OTP for the Password Reset: " + otp; // Set the email body
		MailSenderImpl m = new MailSenderImpl(); // Create an instance of the MailSenderImpl class
		m.sendEmail(to, subject, body); // Invoke the sendEmail method to send the email
		return otp; // Return the generated OTP
	}

	private static void sendEmail(String to, String subject, String body) {
		String host = "smtp.gmail.com"; // SMTP server host (Gmail)
		int port = 587; // SMTP server port (Gmail)

		final String username = "pametineeraj2001@gmail.com"; // Your Gmail account username
		final String password = "agvxucccuiyrehqv"; // Your Gmail account password

		// Set properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true"); // Enable SMTP authentication
		props.put("mail.smtp.starttls.enable", "true"); // Enable TLS encryption
		props.put("mail.smtp.host", host); // Set the SMTP server host
		props.put("mail.smtp.port", port); // Set the SMTP server port

		// Create session
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username)); // Set the sender's email address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // Set the recipient's email
																						// address
			message.setSubject(subject); // Set the email subject
			message.setText(body); // Set the email body

			// Send message
			Transport.send(message); // Send the email

			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private static String generateOTP() {
		Random random = new Random();
		String s = "";
		for (int i = 0; i < 6; i++) {
			int randomIndex = random.nextInt(10);
			s = s + String.valueOf(randomIndex);

		}

		return s;
	}

}
