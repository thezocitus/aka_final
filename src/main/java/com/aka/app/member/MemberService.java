package com.aka.app.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService extends DefaultOAuth2UserService implements UserDetailsService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		log.info("userRequest === {}",userRequest);
		ClientRegistration c = userRequest.getClientRegistration();
		
		log.info("ClientRegistration === {}", c);
		
		OAuth2User user = super.loadUser(userRequest);
		log.info("user === {}",user);
		log.info("===> {}", user.getAttributes());
		log.info("===> {}", user.getAuthorities());
		log.info("===> {}", user.getAttribute("properties").toString());
		
		if(c.getClientName().equals("Kakao")) {
			user = this.kakao(user);
		}
		
		return super.loadUser(userRequest);
	}
	
	private OAuth2User kakao(OAuth2User oAuth2User) {
		Map<String, Object> map = oAuth2User.getAttribute("properties");
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(oAuth2User.getName());
		RoleVO roleVO = new RoleVO();
		roleVO.setName("NORMAL");
		
		memberVO.setRole_id(1L);
		return memberVO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO = new MemberVO();
		memberVO.setUser_id(username);
		
		log.info("로그인~ : {}",username);
		
		try {
			memberVO = memberDAO.getDetail(memberVO);
			log.info("=={}==",memberVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberVO;
	}
	
	public int add(MemberVO memberVO)throws Exception{
		log.info("회원가입~");
		// pw -> 암호화
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));

		int result = memberDAO.add(memberVO);
		
		// 회원 권한 정보
		//role 
		return result; 
	}
	
	// 비번일치/ id중복여부
	public boolean checkMember(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		boolean check = false;
		
		// check가 true 면 error
		// check가 false 면 error  x
		
		check = bindingResult.hasErrors();
		log.info("회원가입 검증");
		// 비번검증
		if(!memberVO.getPassword().equals(memberVO.getPasswordCheck())) {
			check = true;
			// message 등록
			bindingResult.rejectValue("passwordCheck", "memberVO.password.equals");
		}
		
		//id 중복
		MemberVO result = memberDAO.getDetail(memberVO);
		if(result != null) {
			check = true;
			// message 등록
			bindingResult.rejectValue("username", "memberVO.username.equals");
		}
		//
		return check;
	}
	
	public String updatePassword() {
		return "";
	}
	
	public boolean updateMail(MemberVO memberVO) {
//		memberVO.getEmail(), 바꿔줄 비밀번호
		sendMail("rhalsgy@naver.com", "1234");
		return true;
	}
	
	// mail을 보내줄 메서드 (메일 수신자, 변경한 비밀번호)
	private void sendMail(String to, String password) {
		MimeMessage mime = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeHelper = new MimeMessageHelper(mime, true, "UTF-8");
			// 메일받는사람
			mimeHelper.setTo(to);
			// 메일제목
			mimeHelper.setSubject("A.K.A 비밀번호 변경");
			
			// 메일본문
			mimeHelper.setText(
					"<hr>"
					+"<h3>비밀번호 : "+password+"</h3>"
					+"<hr>"
					,true);
			javaMailSender.send(mime);
		} catch (Exception e) {
			throw new RuntimeException("실패");
		}
	}
}




















