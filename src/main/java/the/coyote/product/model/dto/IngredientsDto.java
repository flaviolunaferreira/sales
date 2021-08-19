package the.coyote.product.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.product.model.entity.Ingredients;
import the.coyote.product.model.entity.Products;
import the.coyote.product.model.entity.ProductsConsumer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsDto {
	
	private Integer id;	
	private Products products;
	private ProductsConsumer productsConsumer;
	private BigDecimal quantity;
	
	
	public IngredientsDto(Ingredients ingredients) {
		this.setId(ingredients.getId());
		this.setProducts(ingredients.getProducts());
		this.setProductsConsumer(ingredients.getProductsConsumer());
		this.setQuantity(ingredients.getQuantity());

  	}
}
