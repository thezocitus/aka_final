package com.aka.app.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/member/*")
public class MemberController {

	@GetMapping("/")
	public String test (Model model) {
		return "temp/sample";
	}
	
	@GetMapping("login")
	public String memberLogin() {
		return "member/memberLogin";
	}
	@GetMapping("register")
	public String register() {
		return "member/memberRegister";
	}
}
