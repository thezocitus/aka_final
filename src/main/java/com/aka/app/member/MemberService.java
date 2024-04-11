package com.aka.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService implements UserDetailsService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO = new MemberVO();
		memberVO.setUser_id("user");
		
		log.info("로그인~");
		
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
}




















