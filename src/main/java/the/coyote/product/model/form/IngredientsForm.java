package the.coyote.product.model.form;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import the.coyote.product.model.entity.Ingredients;
import the.coyote.product.model.entity.Products;
import the.coyote.product.model.entity.ProductsConsumer;

public class IngredientsForm {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products products;
	
	@OneToOne
	private ProductsConsumer productsConsumer;
	
	@Column(precision = 12, scale = 3)
	private BigDecimal quantity;

	public Ingredients newIngredientsForm() {
		return new Ingredients(products, productsConsumer, quantity);
	}
	
	
}
