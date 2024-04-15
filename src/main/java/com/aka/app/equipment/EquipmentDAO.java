package com.aka.app.equipment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aka.app.util.Pager;

@Mapper
public interface EquipmentDAO {
	public int deleteEquipment (EquipmentVO equipmentVO) throws Exception;
	
	public int createEquiment (EquipmentVO equipmentVO)throws Exception;
	
	public EquipmentVO getEquimentDetail (EquipmentVO equipmentVO) throws Exception;
	
	public List<EquipmentVO> getEquimentList (Pager pager)throws Exception;  
	
	public Long getTotalCount ()throws Exception;
	
	public int updateEquipment (EquipmentVO equipmentVO)throws Exception;
}
