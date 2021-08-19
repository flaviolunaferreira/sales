package the.coyote.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.product.exceptions.NotFoundException;
import the.coyote.product.model.entity.Ingredients;
import the.coyote.product.model.form.IngredientsForm;

@Service
public interface IngredientsService {

	Ingredients save(IngredientsForm form);
	Ingredients findById(Integer id) throws NotFoundException;
	Ingredients update(Integer id, IngredientsForm form);
	List<Ingredients> findAll();
	void delete(Integer id);
		
}
