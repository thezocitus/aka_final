package com.aka.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import com.aka.app.member.MemberService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SecurityLoginSuccessHandler securityLoginSuccessHandler;
	
	@Autowired
	private SecurityLoginFailureHandler securityLoginFailureHandler;
	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() throws Exception{
		return web -> web
						.ignoring()
						.requestMatchers("/asserts/**")
						.requestMatchers("/fonts/**")
						.requestMatchers("/js/**")
						.requestMatchers("/libs/**")
						.requestMatchers("/scss/**")
						.requestMatchers("/tasks/**");
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
		
		security.authorizeHttpRequests(
				(authorizeHttpRequests) -> 
					
					authorizeHttpRequests
					.requestMatchers("/").permitAll()
			)
			.formLogin(
				(login) -> 
					login
						.loginPage("/login")
						.successHandler(securityLoginSuccessHandler)
						.failureHandler(securityLoginFailureHandler)
						.permitAll()
			);
			
			
		return security.build();
	}
}














