package com.mindfire.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.mindfire.model.User;
@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private final String appUrl;
    private final Locale locale;
    private final User user;

    public OnRegistrationCompleteEvent(final User user, final Locale locale, final String appUrl) {
        super(user);
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
}
