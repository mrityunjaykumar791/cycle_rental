package com.mindfire.event.listener;

import java.util.Locale;
import java.util.Properties;

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
import com.mindfire.event.ResendVerificationTokenEvent;
import com.mindfire.model.User;
import com.mindfire.model.VerificationToken;

@Component
public class ResendVerificationTokenListener implements ApplicationListener<ResendVerificationTokenEvent> {

	@Autowired
	private MessageBean messageBean;

	@Override
	public void onApplicationEvent(ResendVerificationTokenEvent event) {
		try {
			this.resendVerificationToken(event);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void resendVerificationToken(final ResendVerificationTokenEvent event) throws MessagingException {
		final String appUrl = event.getAppUrl();
		final Locale locale = event.getLocale();
		final VerificationToken token = event.getNewToken();
		final User user = event.getUser();

		final Message email = constructResendVerificationTokenEmail(appUrl, locale, token, user);
		Transport.send(email);
	}

	private Message constructResendVerificationTokenEmail(String contextPath, Locale locale, VerificationToken newToken,
			User user) {
		final String recipientAddress = user.getEmail();
		final String subject = "Registration Confirmation";
		final String confirmationUrl = Constant.CONTEXT_ROOT + "/registrationConfirm.html?token=" + newToken.getToken();
		final String message = messageBean.getResendToken();
		final String msg = message + "\r\n" + "<a href='" + confirmationUrl + "'>Click Here</a>";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Constant.MAIL_USERNAME, Constant.MAIL_PASSWORD);
			}
		});

		final Message email = new MimeMessage(session);
		try {
			email.setFrom(new InternetAddress(Constant.MAIL_USERNAME));
			email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientAddress));
			email.setSubject(subject);
			email.setContent(msg, "text/html; charset=utf-8");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return email;
	}
}
