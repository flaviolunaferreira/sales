package the.coyote.product.model.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.product.model.entity.Products;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDto {

	private Integer id;
	private String name;
	private String description;
	
	@Column(precision = 12, scale = 3)
	private BigDecimal priceSales;
	
	@Column(precision = 12, scale = 3)
	private BigDecimal priceCost;		
	

	public ProductsDto(Products products) {
		this.setId(products.getId());
		this.setName(products.getName());
		this.setDescription(products.getDescription());
		this.setPriceCost(products.getPriceCost());
		this.setPriceSales(products.getPriceSales());
  	}
}


