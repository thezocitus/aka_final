package com.aka.app.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {
	
	public int deleteProduct(ProductVO productVO) throws Exception;
	
	public int updateProduct (ProductVO productVO) throws Exception ;
	
	public ProductVO getProductDetail (ProductVO productVO)throws Exception;

	public List<ProductVO> getProductList (ProductVO productVo) throws Exception;
	
	public int createProduct (ProductVO producVO) throws Exception;
}
