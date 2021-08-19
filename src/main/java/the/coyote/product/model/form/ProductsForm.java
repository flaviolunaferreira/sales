package the.coyote.product.model.form;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;
import the.coyote.product.model.entity.Products;

@Data
@Builder
public class ProductsForm {

	@Column(unique = true, nullable = false, length = 50)
	private String name;
	
	@Size(max = 300)
	private String description;
	
	@Column(name = "price_sales", precision = 12, scale = 3)
	private BigDecimal priceSales;
	
	@Column(length = 500)
	private String preparation;

	public Products newProductForm() {
		return new Products( name, description, priceSales, preparation);
	}
	
}
