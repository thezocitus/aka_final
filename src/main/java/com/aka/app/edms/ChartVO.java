package com.aka.app.edms;

import com.nimbusds.jose.shaded.gson.JsonObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ChartVO {
	
	private Integer id;
	private String name;
	private String type;
	private Integer depth;
	private Integer parent;

}
