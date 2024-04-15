package com.aka.app.config;

import java.io.IOException;
import java.net.URLEncoder;

import java.net.URLEncoder;

import javax.security.auth.login.CredentialExpiredException;

import org.apache.ibatis.parsing.TokenHandler;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DatabindException;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SecurityLoginFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		log.info("로그인 실패");
		
		String message = "로그인 실패";
		
		if(exception instanceof AuthenticationException) {
			message = "계정유효기간이 만료되었습니다. (아이디 없음).";
		}
		
		if(exception instanceof BadCredentialsException) {
			message = "비밀번호가 틀립니다.";
		}
		
		if(exception instanceof InternalAuthenticationServiceException) {
			message = "존재하지않는 아이디 입니다.";
		}
			
		if(exception instanceof LockedException) {
			message = "계정이 잠겨있습니다.";
		}
		
		if(exception instanceof CredentialsExpiredException) {
			message = "비밀번호 유효기간이 종료되었습니다.";
		}
		
		if(exception instanceof DisabledException) {
			message = "휴면계정입니다.";
		}
		
		message = URLEncoder.encode(message, "UTF-8");
		
		// 로그인 실패시 메세지를 파라미터로 넣어서 redirect
		response.sendRedirect("/member/login?message"+message);
	}
}
