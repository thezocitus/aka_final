package com.aka.app.edms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edms/*")
public class EdmsController {

	
	@GetMapping("pro/list")
	public String getProlist() {
		
		return "EDMS/prolist";
		
	}
	
	
	
}
