package com.mindfire.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mindfire.component.MessageBean;

@Configuration
@PropertySource("classpath:message.properties")
public class MessageConfiguration {

	@Autowired
	Environment env;

	@Bean
	public MessageBean messageBean() {
		MessageBean messageBean = new MessageBean();
		messageBean.setRegSucc(env.getProperty("message.regSucc"));
		messageBean.setInvalidToken(env.getProperty("message.invalidToken"));
		messageBean.setExpired(env.getProperty("message.expired"));
		messageBean.setContextPath(env.getProperty("contextpath"));
		messageBean.setResendToken(env.getProperty("message.resendToken"));
		return messageBean;
	}

}
