package com.aka.app.edms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nimbusds.jose.shaded.gson.JsonArray;
import com.nimbusds.jose.shaded.gson.JsonObject;

import org.springframework.web.bind.annotation.RequestParam;



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
	public String createEdms(Model model) throws Exception {
		
		
		//직원목록 불러오기
		List<Map<String, String>> result = edmsService.getMemberList(); 
		
		List<ChartVO> chartAr = edmsService.getDeptList();
		
		Map<String, String> list = new HashMap<>();
		
		System.out.println(chartAr.get(0).getName());
		
		JsonArray jsonAr = new JsonArray();		
		//chart list에 부서 넣기
//		for (Map<String, String> a : deptList) {
//			
//			
//			
//			list.put("id", a.get("DEPARTMENT_ID"));
//			list.put("name", a.get("DEPARTMENT_NAME"));
//			list.put("type", "dept");
//			list.put("depth", a.get("depth"));			
//			list.put("parent", a.get(" DEPARTMENT_SUPER_ID"));
//		JsonObject jsonObject = new JsonObject();
//		
//			
//		}
		System.out.println(result);
				
		
		
				
		
		
		model.addAttribute("list",result);		
		
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
	
	
	
	
	
	@GetMapping("api/Chart")
	@ResponseBody
	public List<ChartVO> getMethodName() throws Exception {
		
		 List<ChartVO> result =edmsService.getDeptList();
		
		 for(ChartVO chartVO : result) {
			 
			 chartVO.setType("dept");
			 
			 System.out.println("apichart"+chartVO);
		 }
		 
		
		 
		return result;
		
		
		
		
	}
	
	
	
	
	//직원목록 불러오기
	
	
	
}
