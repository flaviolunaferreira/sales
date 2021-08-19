package the.coyote.product.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the.coyote.product.exceptions.IntegratyViolationException;
import the.coyote.product.exceptions.NotFoundException;
import the.coyote.product.model.entity.ProductsConsumer;
import the.coyote.product.model.form.ProductsConsumerForm;
import the.coyote.product.repositories.ProductsConsumerRepository;
import the.coyote.product.services.ProductsConsumerService;

@Service
public class ProductsConsumerServiceImpl implements ProductsConsumerService{

	private ProductsConsumerRepository repository;
	
	@Autowired
	public ProductsConsumerServiceImpl(ProductsConsumerRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public ProductsConsumer save(ProductsConsumerForm form) {
		ProductsConsumer productsConsumer = form.newProductConsumerForm();
		return repository.save(productsConsumer);
	}

	@Override
	public List<ProductsConsumer> findAll() {
		List<ProductsConsumer> productsConsumer = (List<ProductsConsumer>) repository.findAll();		
		return productsConsumer;
	}

	@Override
	public ProductsConsumer findById(Integer id) throws NotFoundException {
		Optional<ProductsConsumer> result = repository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("Sorry But couldn't find the product with the id " + id));
	}


	@Override
	public List<ProductsConsumer> findByName(String name) {
		List<ProductsConsumer> result = repository.findByNameIgnoreCaseContaining(name);
		return result;
	}

	@Override
	public ProductsConsumer update(Integer id, ProductsConsumerForm form) {
		ProductsConsumer result = findById(id);
		{
			result.setName(form.getName());
			result.setImage(form.getImage());
		}		
		return repository.save(result);
	}

	@Override
	public void delete(Integer id) {
		ProductsConsumer result = findById(id);
		try {
			repository.delete(result);
		} catch (IntegratyViolationException e) {
			throw new IntegratyViolationException("Product of Consumer cannot by DELETED! it has associated Products");
		}
	}

}
