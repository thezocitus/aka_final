package com.aka.app.edms;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EdmsDAO {

	public int createEdms(EdmsVO edmsVO)throws Exception;
	
	
	
	//맴버 리스트 가져오기
	public List<Map<String, String>> getMemberList() throws Exception;
	
	
}
