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

import com.aka.app.equipment.EquipmentVO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("update")
	public void updateProduct () throws Exception {
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
