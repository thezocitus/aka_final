package com.aka.app.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.aka.app.edms.EdmsService;

public class Chart {
	
	
	@Autowired
	private EdmsService edmsService;
	
	public List<Map<String, Object>> createChart(int s) throws Exception{		
		
		List<Map<String, Object>> result = new ArrayList<>();
		if(s==0 && s==1) {		
		 
			result =edmsService.getDeptChart();
			for(Map<String, Object> a : result) {			 
			
			 a.replace("parent", "0", "#");
//			 a.put("type", "dept");
			
		 }
		}
		
		if(s==1) {
			
			List<Map<String, Object>>  temp = edmsService.getMemberChart();
			
			
		}
		
		 System.out.println("apichart"+result);
		
		 
		return result;		
		
		
	}

}
