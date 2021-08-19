package the.coyote.product.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import the.coyote.product.model.entity.ProductsConsumer;

public interface ProductsConsumerRepository extends PagingAndSortingRepository<ProductsConsumer, Integer>{

	List<ProductsConsumer> findByNameIgnoreCaseContaining(String name);

}
