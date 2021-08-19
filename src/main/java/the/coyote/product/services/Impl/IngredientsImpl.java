package the.coyote.product.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the.coyote.product.exceptions.IntegratyViolationException;
import the.coyote.product.exceptions.NotFoundException;
import the.coyote.product.model.entity.Ingredients;
import the.coyote.product.model.form.IngredientsForm;
import the.coyote.product.repositories.IngredientsRepository;
import the.coyote.product.services.IngredientsService;

@Service
public class IngredientsImpl implements IngredientsService{

	private IngredientsRepository repository;

	@Autowired
	public IngredientsImpl(IngredientsRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public Ingredients save(IngredientsForm form) {
		Ingredients Ingredients = form.newIngredientsForm();
		return repository.save(Ingredients);
	}

	@Override
	public List<Ingredients> findAll() {
		List<Ingredients> Ingredients = (List<Ingredients>) repository.findAll();		
		return Ingredients;
	}

	@Override
	public Ingredients findById(Integer id) throws NotFoundException {
		Optional<Ingredients> result = repository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("Sorry But couldn't find the product with the id " + id));
	}


	@Override
	public Ingredients update(Integer id, IngredientsForm form) {
		Ingredients result = findById(id);
		{
			result.setProducts(result.getProducts());
			result.setProductsConsumer(result.getProductsConsumer());
			result.setQuantity(result.getQuantity());
		}		
		return repository.save(result);
	}

	@Override
	public void delete(Integer id) {
		Ingredients result = findById(id);
		try {
			repository.delete(result);
		} catch (IntegratyViolationException e) {
			throw new IntegratyViolationException("Product of Consumer cannot by DELETED! it has associated Ingredients");
		}
	}

	

}
