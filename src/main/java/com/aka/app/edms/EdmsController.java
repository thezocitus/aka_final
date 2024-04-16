package com.aka.app.edms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edms/*")
public class EdmsController {

	
	@GetMapping("pro/list")
	public String getProlist() {
		
		return "EDMS/prolist";
		
	}
	
	/*
	 * @GetMapping("form") public String getform(Model model) {
	 * model.addAttribute("path","form"); return "EDMS/prolist";
	 * 
	 * }
	 */
	
	@GetMapping("form")
	public String getform(Model model) {
		
		return "EDMS/form";
		
	}
	
	@GetMapping("create")
	public String create(Model model) {
		
		return "EDMS/create";
		
	}
	
}
