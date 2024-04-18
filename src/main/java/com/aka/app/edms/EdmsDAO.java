package com.aka.app.edms;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EdmsDAO {

	
	public int createEdms(EdmsVO edmsVO) throws Exception;
	
	
	
	
	
	
	//직원목록 불러오기
	public List<Map<String, String>> getMemberList() throws Exception;
	
	
	//부서목록 가져오기
//	public List<ChartVO> getDeptList() throws Exception;
	public List<Map<String, Object>> getDeptList() throws Exception;
}
