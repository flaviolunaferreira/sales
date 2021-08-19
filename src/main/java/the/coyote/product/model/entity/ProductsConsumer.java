package the.coyote.product.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsConsumer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 60)
	private String name;

	@Column(precision = 12, scale = 3)
	private BigDecimal price;
	
	@Column(precision = 12, scale = 3)
	private BigDecimal inventory;

	@Column(name = "minimun_stock", precision = 12, scale = 3)
	private BigDecimal minimumStock;
	
	@URL
	private String image;
	
	@Builder.Default
	private LocalDateTime createdAt = LocalDateTime.now();

	public ProductsConsumer(String name, @URL String image) {
		super();
		this.name = name;
		this.image = image;
	}

	
}
