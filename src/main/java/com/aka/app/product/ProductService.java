package com.aka.app.product;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public int deleteProduct(ProductVO productVO) throws Exception {
		return productDAO.deleteProduct(productVO);
	}
	
	public int updateProduct(ProductVO productVO) throws Exception {
		return productDAO.updateProduct(productVO);
	}
	
	public ProductVO getProductDetail (ProductVO productVO) throws Exception {
		return productDAO.getProductDetail(productVO);
	}
	
	public int createProduct (ProductVO productVO) throws Exception {
		Random random = new Random();
		if(productVO.getProduct_photos() == null) {
			productVO.setProduct_photos("/assets/img/elements/"+random.nextInt(7)+".jpg");
		}
		productVO.setMember_id(1L);
		return productDAO.createProduct(productVO);
	}
	
	public List<ProductVO> getProductList (ProductVO productVO) throws Exception {
		return  productDAO.getProductList(productVO);
	}
}
