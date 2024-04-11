package com.aka.app.edms;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
public class EdmsVO {
	
	private Long edmsNo;
	private String edmsFromNo;
	private Long edmsCreator;
	private String edmsTitle;	
	private String edmsContent;
	private String edmsStatus;
	private Date edmsApplovalDate;
	private Date edmsCreateDate;
	private Date edmsExpDate;
	private Integer edms_use;
	private Date edmsExtraDate1;
	private Date edmsExtraDate2;
	private String edmsExtraContent;
	private Long edmsExtraNumber;
	private String edmsCreatorPosition;	

	
	private List<FileVO> fileVOs; 
	
}
	
