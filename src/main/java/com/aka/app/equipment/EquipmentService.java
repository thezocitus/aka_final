package com.aka.app.equipment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aka.app.util.Pager;

@Service
public class EquipmentService {
	
	@Autowired
	private EquipmentDAO equipmentDAO;
	
	public int deleteEquipment(EquipmentVO equipmentVO) throws Exception {
		return equipmentDAO.deleteEquipment(equipmentVO);
	}
	
	public int updateEquipment (EquipmentVO equipmentVO) throws Exception {
		return createEquiment(equipmentVO);
	}
	
	public int createEquiment (EquipmentVO equipmentVO) throws Exception {
		
		return equipmentDAO.createEquiment(equipmentVO);
	}
	
	public EquipmentVO getEquimentDetail (EquipmentVO equipmentVO) throws Exception {
		return equipmentDAO.getEquimentDetail(equipmentVO);
	}
	
	public List<EquipmentVO> getEquimentList (Pager pager) throws Exception {
		pager.makeIndex();
		pager.makeNum(equipmentDAO.getTotalCount());
		return  equipmentDAO.getEquimentList(pager);
	}
}
