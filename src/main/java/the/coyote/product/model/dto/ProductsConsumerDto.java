package the.coyote.product.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.product.model.entity.ProductsConsumer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsConsumerDto {

	private Integer id;	
	private String name;
	private BigDecimal price;
	private BigDecimal inventory;
	private String image;
	private LocalDateTime createdAt;

	public ProductsConsumerDto(ProductsConsumer productsConsumer) {
		this.setId(productsConsumer.getId());
		this.setName(productsConsumer.getName());
		this.setPrice(productsConsumer.getPrice());
		this.setInventory(productsConsumer.getInventory());
		this.setImage(productsConsumer.getImage());
	}
	
	
}
