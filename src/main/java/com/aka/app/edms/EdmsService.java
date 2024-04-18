package com.aka.app.edms;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdmsService {
	
	
	@Autowired
	private EdmsDAO edmsDAO;
	
	
	public int createEdms(EdmsVO edmsVO) throws Exception {
		
		System.out.println("service 16    "+ edmsVO);
		
		
		return edmsDAO.createEdms(edmsVO);
		
	}
	
	
	
	//직원목록 불러오기
	public List<Map<String, String>> getMemberList()throws Exception{
		
				
		return edmsDAO.getMemberList(); 
		
	}
	
//	public List<ChartVO> getDeptList() throws Exception{
//		
//		return edmsDAO.getDeptList();
//	}
	
	
	
	// 차트 불러오기
	//부서
	public List<Map<String, Object>> getDeptChart() throws Exception{
		
		return edmsDAO.getDeptChart();
	}
	
	//사원
	public List<Map<String, Object>> getMemberChart() throws Exception{
		
		return edmsDAO.getMemberChart();
	}
}
