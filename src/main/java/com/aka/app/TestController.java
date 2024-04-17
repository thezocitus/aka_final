package com.aka.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aka.app.member.MemberService;
import com.aka.app.member.MemberVO;

@Controller
public class TestController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String test (Model model) {
		return "temp/sample";
	}
	
	
	@GetMapping("/test/test")
	public String test2(MemberVO memberVO) {
		memberService.updateMail(null);
		return "redirect:/";
	}
}
