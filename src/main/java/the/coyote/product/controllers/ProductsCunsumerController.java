package the.coyote.product.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import the.coyote.product.exceptions.NotFoundException;
import the.coyote.product.model.dto.ProductsConsumerDto;
import the.coyote.product.model.entity.ProductsConsumer;
import the.coyote.product.model.form.ProductsConsumerForm;
import the.coyote.product.services.ProductsConsumerService;

@RestController
@RequestMapping(value = "/api/products_costumer")
public class ProductsCunsumerController {

	private ProductsConsumerService service;

	@Autowired
	public ProductsCunsumerController(ProductsConsumerService service) {
		super();
		this.service = service;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) throws NotFoundException{
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid ProductsConsumerForm form ) {
		ProductsConsumer saved = service.save(form);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(uri).body(saved);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<ProductsConsumer> list = service.findAll();
		List<ProductsConsumerDto> listDto = list.stream()
				.map(item -> new ProductsConsumerDto(item))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<List<?>> findByName(@PathVariable String name) {
		List<ProductsConsumer> result = service.findByName(name);
		return ResponseEntity.ok().body(result);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ProductsConsumerForm form) {
		ProductsConsumer saved = service.update(id, form);
		return ResponseEntity.ok().body(saved);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
