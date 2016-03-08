package com.mindfire.event.listener;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.mindfire.component.MessageBean;
import com.mindfire.constants.Constant;
import com.mindfire.event.OnRegistrationCompleteEvent;
import com.mindfire.model.User;
import com.mindfire.services.UserService;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

	@Autowired
    private UserService service;
	
	@Autowired
	private MessageBean messageBean;
    @Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
    	try {
			this.confirmRegistration(event);
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		}
		
	}
    private void confirmRegistration(final OnRegistrationCompleteEvent event) throws MessagingException {
        final User user = event.getUser();
        final String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);

        final Message email = constructEmailMessage(event, user, token);
        Transport.send(email);
    }
	
	private final Message constructEmailMessage(final OnRegistrationCompleteEvent event, final User user, final String token) {
        final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String confirmationUrl = Constant.CONTEXT_ROOT +"/registrationConfirm.html?token=" + token;
        final String message = messageBean.getRegSucc();
        final String msg = message + "\r\n" + "<a href='"+confirmationUrl+"'>Click Here</a>";
        
        System.out.println(confirmationUrl);
        
        Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Constant.MAIL_USERNAME, Constant.MAIL_PASSWORD);
			}
		  });
		
		final Message email = new MimeMessage(session);
		try {
			email.setFrom(new InternetAddress(Constant.MAIL_USERNAME));
			email.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipientAddress));
			email.setSubject(subject);
			email.setContent(msg, "text/html; charset=utf-8");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return email;
    }
}
