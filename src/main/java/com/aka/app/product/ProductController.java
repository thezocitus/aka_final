package com.aka.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aka.app.equipment.EquipmentVO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("delete")
	public String deleteProduct (ProductVO productVO,Model model) throws Exception {
		int result;
		String msg = "상품 삭제 실패";
		if(productVO != null) {
			productService.deleteProduct(productVO);
			msg = "상품 삭제 성공";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("path","/product/list");
		return "commons/result";
	}
	
	@GetMapping("update")
	public ModelAndView updateProduct (ProductVO productVO,ModelAndView mv) throws Exception {
		productVO = productService.getProductDetail(productVO);
		mv.addObject("vo",productVO);
		mv.setViewName("product/update");
		return mv;
	}
	
	@PostMapping("update")
	public String updateProduct (ProductVO productVO,Model model) throws Exception {
		int result;
		String msg = "상품 수정 실패";
		result = productService.updateProduct(productVO);
		if(result==1) {
			msg = "상품 수정 성공";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("path","/product/list");
		return "commons/result";
	}
	
	
	@GetMapping("detail")
	public void getProductDetail(ProductVO productVO,Model model) throws Exception {
		productVO = productService.getProductDetail(productVO);
		model.addAttribute("vo",productVO);
	}
	
	@GetMapping("create")
	public void createProduct (@ModelAttribute ProductVO productVO) throws Exception {
	}
	
	@PostMapping("create")
	public String createProduct (@Valid ProductVO productVO,BindingResult bindingResult,Model model) throws Exception {
		int result=0;
		String msg = "상품 추가 실패";
		if(bindingResult.hasErrors()) {  //폼 검증 실패시
			return "product/create"; 
		}
		result = productService.createProduct(productVO);
		if(result==1) msg="상품 추가 성공";
		model.addAttribute("msg",msg);
		model.addAttribute("path","/product/list");
		return "commons/result";
	}
	
	@GetMapping("list")
	public void getProductList (ProductVO productVO,Model model) throws Exception {
		List<ProductVO> list = productService.getProductList(productVO);
		model.addAttribute("list",list);	
	}
	
	
}
