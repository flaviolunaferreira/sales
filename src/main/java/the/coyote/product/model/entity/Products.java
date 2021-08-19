package the.coyote.product.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable = false, length = 50)
	private String name;
	
	@Size(max = 300)
	private String description;
	
	@Column(name = "price_sales", precision = 12, scale = 3)
	private BigDecimal priceSales;
	
	@Column(name = "price_cost", precision = 12, scale = 3)
	private BigDecimal priceCost;
	
	@Column(length = 500)
	private String preparation;
	
	@Builder.Default
	@OneToMany(mappedBy = "products")
	private List<Ingredients> ingredients = new ArrayList<Ingredients>();	
	
	@Builder.Default
	private LocalDateTime createdAt = LocalDateTime.now();

	public Products(String name, String description, BigDecimal priceSales, String preparation) {
		super();
		this.name = name;
		this.description = description;
		this.priceSales = priceSales;
		this.preparation = preparation;
		
	}
}
