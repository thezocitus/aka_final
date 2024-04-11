package com.aka.app.edms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping("/edms/*")
public class EdmsController {
	
	@Autowired
	private EdmsService edmsService;
	
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
	public String createEdms(Model model) {
		
		return "EDMS/create";
		
	}
	
	@PostMapping("apply")
	@ResponseBody
	public Map<String, Object> apply(String [] ar, EdmsVO edmsVO, Model model, MultipartFile[] file) throws Exception {		

		
		Map<String, Object> map = new HashMap<String, Object>();
		 
		System.out.println("edms65 AR   "+ar.length);
		System.out.println("edms65 AR   "+ar[0]);
		System.out.println(edmsVO.getEdmsContent());
		//기안서 파일을 저장
		if(file!=null) {
			
			System.out.println(file[0].getOriginalFilename());
		}
		
		
		map.put("edmsVO", edmsVO);
		
		// 기안서 내용을 저장.		
//		int result = edmsService.createEdms(edmsVO);
//		
//		String msg = "성골";
//		
//		if(result!=1) {			
//			msg = "실패";
//		}				
//		map.put("result", msg);		
		return map; 		
		 
	}
	
	
	
	
	
	@GetMapping("form/draft")
	
	public String getformDraft(Model model) {
		
		return "EDMS/form/draft";
		
	}
	
	
}
