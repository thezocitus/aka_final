package com.aka.app.config;



import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

//	@Autowired
//	private MemberService memberService;
	
	@Autowired
	private SecurityLoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	private SecurityLoginFailureHandler loginFailureHandler;



@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

//	@Autowired
//	private MemberService memberService;
	
	@Autowired
	private SecurityLoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	private SecurityLoginFailureHandler loginFailureHandler;
	
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
	SecurityFilterChain filterChain (HttpSecurity security) throws Exception {
		
		log.info("security config");
		security
				//CSRF 추가
				.csrf(
						(csrf) -> 
									csrf.disable()
				)
				.authorizeHttpRequests(
						(authorizeRequests)->
											authorizeRequests
											.anyRequest().permitAll()
											)
											
				.formLogin(
							(login)->
									login	
									.loginPage("/member/login")
									.successHandler(loginSuccessHandler)
									.usernameParameter("user_id") 
									.defaultSuccessUrl("/")
									.failureHandler(loginFailureHandler)
									
									.permitAll()

									
						)// 로그인 끝부분
				.logout(
							(logout)->
									logout
										.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
										.logoutSuccessUrl("/")
										.invalidateHttpSession(true) // 로그아웃 성공시 session만료
										.permitAll()
						)// 로그아웃 끝 부분
				.sessionManagement(
						(sessionManagement)->
							sessionManagement
								.maximumSessions(1)
								.maxSessionsPreventsLogin(false)
								.expiredUrl("/expired")
								
				)//sessionManagement 끝
				;	
		
		
		
		return security.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		// password 암호화 해주는 객체
		return new BCryptPasswordEncoder();
	}
	}
}













