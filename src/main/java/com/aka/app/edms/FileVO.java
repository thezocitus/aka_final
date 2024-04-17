package com.aka.app.edms;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileVO {

	private Long edmsAttechfileNo;
	private Long edmsNo;
	private String edmsAttechfileName;
	private String edmsAttechfileOriName;	
	private MultipartFile[] file; 		
	
	
}
