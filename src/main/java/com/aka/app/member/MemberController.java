package com.aka.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String test (Model model) {
		return "temp/sample";
	}
	
	@GetMapping("login")
	public String memberLogin(@ModelAttribute MemberVO memberVO, HttpSession session)throws Exception {
		
		
		Object obj=session.getAttribute("SPRING_SECURITY_CONTEXT");
		log.info("===============memberVO : {}",memberVO);
		if(obj == null) {
			return "member/memberLogin";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("register")
	public String register(@ModelAttribute MemberVO memberVO) throws Exception{
		
		return "member/memberRegister";
	}
	
	@PostMapping("register")
	public String register(@Validated MemberVO memberVO, BindingResult bindingResult, Model model)throws Exception{
		
		int result = memberService.add(memberVO);
	    
	    String msg = "가입 실패";
	    String path = "./join";

	    if (result > 0) {
	        msg = "가입 성공";
	        path = "../";
	    }

	    model.addAttribute("msg", msg);
	    model.addAttribute("path", path);
	    
		return "commons/result";
	}
}
