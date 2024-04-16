package com.aka.app.equipment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aka.app.util.Pager;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Transactional
@RequestMapping("/equipment/*")
public class EquipmentController {
	
	@Autowired
	private EquipmentService equipmentService;
	
	@PostMapping("delete")
	public String deleteEquipment(EquipmentVO equipmentVO,Model model) throws Exception {
		int result=0;
		String msg = "비품 삭제 실패";
		if(equipmentVO.getEquipment_num() != null) {				//인자값이 NUL 이 아니라면
			result = equipmentService.deleteEquipment(equipmentVO); //db삭제성공 1  , db삭제 실패 0
			if(result == 1) msg = "비품 삭제 성공";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("path","/equipment/list");				
		return "commons/result";
	}
	@GetMapping("update")
	public ModelAndView updateEquipment(EquipmentVO equipmentVO,ModelAndView modelAndView) throws Exception {
		equipmentVO = equipmentService.getEquimentDetail(equipmentVO);
		modelAndView.addObject("vo",equipmentVO);
		modelAndView.setViewName("product/update");
		return modelAndView;
	}
	@PostMapping("update")
	public String updateEquipment(EquipmentVO equipmentVO,Model model) throws Exception{
		int result=0;
		String msg = "비품 수정 실패";
		if(equipmentVO.getEquipment_num() != null) { 
			result = equipmentService.updateEquipment(equipmentVO);
			if(result == 1) msg = "비품 삭제 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", "/equipment/list");
		return"commons/result";
	}
	
	
	@GetMapping("create")
	public void createEquipment(@ModelAttribute EquipmentVO equipmentVO) throws Exception{
	}
	@PostMapping("create")
	public String createEquipment(@Valid EquipmentVO equipmentVO,BindingResult bindingResult,Model model) throws Exception{
		int result=0;
		String msg = "비품 추가 실패";
		if(bindingResult.hasErrors()) {
			//form 검증 실패시 
			return "equipment/create";
		}
		equipmentVO.setMember_id(1L);
		result = equipmentService.createEquiment(equipmentVO);
		if(result ==1) msg = "비품 추가 성공";
		model.addAttribute("msg", msg);
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
