package com.aka.app.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Value("${spring.mail.host}")
	private String host;
	@Value("${spring.mail.port}")
	private int port;
	@Value("${spring.mail.username}")
	private String username;
	@Value("${spring.mail.password}")
	private String password;
	
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailImpl = new JavaMailSenderImpl();
		
		mailImpl.setHost(host);
		mailImpl.setPort(port);
		mailImpl.setUsername(username);
		mailImpl.setPassword(password);
		
		mailImpl.setJavaMailProperties(getProperties());
		
		return mailImpl;
	}
	
	private Properties getProperties() {
		Properties properties = new Properties();
		
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("spring.mail.debug","true");
		properties.setProperty("spring.mail.default.encoding", "UTF-8");
		properties.setProperty("spring.mail.mime.charset", "UTF-8");
		
		return properties;
	}
}
