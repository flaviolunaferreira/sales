package the.coyote.product.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import the.coyote.product.model.entity.Ingredients;

public interface IngredientsRepository extends PagingAndSortingRepository<Ingredients, Integer> {
	
}
