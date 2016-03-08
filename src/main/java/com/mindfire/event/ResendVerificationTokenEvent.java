package com.mindfire.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.mindfire.model.User;
import com.mindfire.model.VerificationToken;

@SuppressWarnings("serial")
public class ResendVerificationTokenEvent extends ApplicationEvent{
	
	private final String appUrl;
    private final Locale locale;
    private final VerificationToken newToken;
    private final User user;

    public ResendVerificationTokenEvent(final String appUrl, final Locale locale, final VerificationToken newToken, final User user) {
		super(user);
		this.appUrl = appUrl;
		this.locale = locale;
		this.newToken = newToken;
		this.user = user;
	}

	/**
	 * @return the appUrl
	 */
	public String getAppUrl() {
		return appUrl;
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @return the newToken
	 */
	public VerificationToken getNewToken() {
		return newToken;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
}
