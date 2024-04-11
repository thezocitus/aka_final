package com.aka.app.edms;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EdmsDAO {

	
	public int createEdms(EdmsVO edmsVO) throws Exception;
	
	
	
}
