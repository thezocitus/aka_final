package com.aka.app.product;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {

	private Long product_num;
	private Long member_id;
	@NotEmpty(message = "상품 이름을 입력하세요")
	private String product_name;
	@NotNull(message="상품 가격을 입력하세요")
	private Long product_price;
	@Min(value=1L,message ="상품 기간을 입력하세요")
	private Long product_date;
	private String product_detail;
	private String product_photos;
}
