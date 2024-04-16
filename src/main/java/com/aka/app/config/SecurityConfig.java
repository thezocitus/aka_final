package com.aka.app.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.aka.app.member.MemberService;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

	@Autowired
	private MemberService memberService;
	
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
											.requestMatchers("/", "/login**", "/edms/**").authenticated()
//											.requestMatchers("/").permitAll()
//											.requestMatchers("/member/login").permitAll()
											.anyRequest().permitAll()
											)
				
				.formLogin(
						(login)->
								login	
								.loginPage("/member/login")
								.successHandler(loginSuccessHandler)
								.usernameParameter("userId") 
								.defaultSuccessUrl("/")
								.failureHandler(loginFailureHandler)
								
								.permitAll()

						)// 로그인 끝부분
						.logout(
							(logout)->
									logout
										.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
										.logoutSuccessUrl("/member/login")
										.invalidateHttpSession(true) // 로그아웃 성공시 session만료
										.deleteCookies("JSESSIONID")
										.permitAll()
						)// 로그아웃 끝 부분
						.rememberMe(
								(rememberMe ->
									rememberMe
										.rememberMeParameter("rememberMe")
										.tokenValiditySeconds(600)				// 초단위
										.key("rememberMe")
										.userDetailsService(memberService)
										.authenticationSuccessHandler(loginSuccessHandler)
										.useSecureCookie(false)
								)		
						)// rememberMe 끝부분
						.sessionManagement(
							(sessionManagement)->
								sessionManagement								
									.maximumSessions(1)
									.maxSessionsPreventsLogin(true)		// true 이면 같은아이디로 로그인되어있으면 로그인을 거부/ false 로그인된 사용자 세션 만료
									.expiredUrl("/expired")
						)//sessionManagement 끝
						.oauth2Login(
								(oauth2Login) -> 
								oauth2Login.userInfoEndpoint(
										(ue) -> ue.userService(memberService)
							)
						)//oauth2Login 끝
						;
		
		return security.build();
	}
	

	
}