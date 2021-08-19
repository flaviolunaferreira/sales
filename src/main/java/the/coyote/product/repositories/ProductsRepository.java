package the.coyote.product.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import the.coyote.product.model.entity.Products;

public interface ProductsRepository extends PagingAndSortingRepository<Products, Integer>{

	List<Products> findByNameIgnoreCaseContaining(String name);
	
}
