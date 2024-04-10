package com.aka.app.config;

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

import com.aka.app.member.MemberService;

@Configuration
@EnableWebSecurity
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
						.loginProcessingUrl("/") 				// 인증처리 수행
						.successHandler(loginSuccessHandler)	// 정상 인증 성공후 커스텀 핸들러
						.failureHandler(loginFailureHandler)	// 인증 실패 후 커스텀 핸들러
//						.failureUrl("/login/fail")				// 로그인 실패시 url (default 는 로그인 페이지)
						.permitAll()
			)
			.logout(
					(logout ->
						logout
							.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
							.logoutSuccessUrl("/")					// 로그아웃 후 url
							.invalidateHttpSession(true)			// 세션만료
							.permitAll()
					)
					
			);
			
			
		return security.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		// pw 암호화 객체
		return new BCryptPasswordEncoder();
	}
}














