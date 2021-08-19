package the.coyote.product.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the.coyote.product.exceptions.IntegratyViolationException;
import the.coyote.product.exceptions.NotFoundException;
import the.coyote.product.model.entity.Products;
import the.coyote.product.model.form.ProductsForm;
import the.coyote.product.repositories.ProductsRepository;
import the.coyote.product.services.ProductsService;

@Service
public class ProductsImpl implements ProductsService {

	private ProductsRepository repository;
	
	@Autowired
	public ProductsImpl(ProductsRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Products save(ProductsForm form) {
		Products products = form.newProductForm();
		return repository.save(products);
	}

	@Override
	public List<Products> findAll() {
		List<Products> products = (List<Products>) repository.findAll();		
		return products;
	}

	@Override
	public Products findById(Integer id) throws NotFoundException {
		Optional<Products> result = repository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("Sorry But couldn't find the product with the id " + id));
	}


	@Override
	public List<Products> findByName(String name) {
		List<Products> result = repository.findByNameIgnoreCaseContaining(name);
		return result;
	}

	@Override
	public Products update(Integer id, ProductsForm form) {
		Products result = findById(id);
		{
			result.setName(form.getName());
			result.setDescription(form.getDescription());
			result.setPreparation(result.getPreparation());
			result.setPriceSales(form.getPriceSales());
		}		
		return repository.save(result);
	}

	@Override
	public void delete(Integer id) {
		Products result = findById(id);
		try {
			repository.delete(result);
		} catch (IntegratyViolationException e) {
			throw new IntegratyViolationException("Product of Consumer cannot by DELETED! it has associated Products");
		}
	}

}
