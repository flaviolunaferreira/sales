package the.coyote.product.model.form;

import javax.persistence.Column;

import org.hibernate.validator.constraints.URL;

import lombok.Builder;
import lombok.Data;
import the.coyote.product.model.entity.ProductsConsumer;

@Data
@Builder

public class ProductsConsumerForm {

	@Column(nullable = false, length = 60)
	private String name;
	
	@URL
	private String image;

	public ProductsConsumer newProductConsumerForm() {
		return new ProductsConsumer( name, image);
	}
		
}
