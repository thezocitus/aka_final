package com.aka.app.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/")
	public String test (Model model) {
		return "temp/sample";
	}
	
	@GetMapping("/login")
	public String loginSel() {
		return "member/first";
	}
	@GetMapping("/login/memberLogin")
	public String memberLogin() {
		return "member/memberLogin";
	}
	@GetMapping("/login/memberRegister")
	public String register() {
		return "member/memberRegister";
	}
}
