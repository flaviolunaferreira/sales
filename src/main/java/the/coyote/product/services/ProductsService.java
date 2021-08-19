package the.coyote.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.product.exceptions.NotFoundException;
import the.coyote.product.model.entity.Products;
import the.coyote.product.model.form.ProductsForm;

@Service
public interface ProductsService {

	Products save(ProductsForm form);
	Products findById(Integer id) throws NotFoundException;
	Products update(Integer id, ProductsForm form);
	List<Products> findAll();
	List<Products> findByName(String name);
	void delete(Integer id);
	
}
