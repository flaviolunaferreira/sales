package the.coyote.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.product.exceptions.NotFoundException;
import the.coyote.product.model.entity.ProductsConsumer;
import the.coyote.product.model.form.ProductsConsumerForm;

@Service
public interface ProductsConsumerService {

	ProductsConsumer save(ProductsConsumerForm form);
	ProductsConsumer findById(Integer id) throws NotFoundException;
	ProductsConsumer update(Integer id, ProductsConsumerForm form);
	List<ProductsConsumer> findAll();
	List<ProductsConsumer> findByName(String name);
	void delete(Integer id);
	
}
