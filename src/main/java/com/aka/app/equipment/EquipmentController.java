package com.aka.app.equipment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aka.app.util.Pager;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/equipment/*")
public class EquipmentController {
	
	@Autowired
	private EquipmentService equipmentService;
	
	
	
	@GetMapping("update")
	public void updateEquipment(EquipmentVO equipmentVO,Model model) throws Exception {
		equipmentVO = equipmentService.getEquimentDetail(equipmentVO);
		model.addAttribute("vo",equipmentVO);
	}
	@PostMapping("update")
	public String updateEquiment(EquipmentVO equipmentVO,BindingResult bindingResult,Model model) throws Exception{
		if(bindingResult.hasErrors()) {
			//form 검증 실패시 
			return "equipment/update";
		}
		int result = equipmentService.updateEquipment(equipmentVO);
		model.addAttribute("msg", "비품 수정 성공");
		model.addAttribute("path", "/equipment/list");
		return"commons/result";
	}
	
	
	@GetMapping("create")
	public void createEquiment(@ModelAttribute EquipmentVO equipmentVO,Model model) throws Exception{
	}
	@PostMapping("create")
	public String createEquiment(@Valid EquipmentVO equipmentVO,BindingResult bindingResult,Model model) throws Exception{
		if(bindingResult.hasErrors()) {
			//form 검증 실패시 
			return "equipment/create";
		}
		equipmentVO.setMember_id(1L);
		int result = equipmentService.createEquiment(equipmentVO);
		model.addAttribute("msg", "비품 추가 성공");
		model.addAttribute("path", "/equipment/list");
		return"commons/result";
	}
	
	@GetMapping("detail")
	public String getEquimentDetail (Model model,EquipmentVO equipmentVO) throws Exception {
		equipmentVO = equipmentService.getEquimentDetail(equipmentVO);
		model.addAttribute("vo",equipmentVO);
		return "equipment/detail";
	}
	
	@GetMapping("list")
	public String getEquimentList (Model model,Pager pager) throws Exception {
		List<EquipmentVO> list = equipmentService.getEquimentList(pager);
		model.addAttribute("list",list);
		model.addAttribute("pager",pager);
		return "equipment/list";
	}
}
