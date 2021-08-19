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
import the.coyote.product.model.dto.IngredientsDto;
import the.coyote.product.model.entity.Ingredients;
import the.coyote.product.model.form.IngredientsForm;
import the.coyote.product.services.IngredientsService;

@RestController
@RequestMapping(value = "/api/ingredients")
public class IngrediantsController {

	private IngredientsService service;

	@Autowired
	public IngrediantsController(IngredientsService service) {
		super();
		this.service = service;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) throws NotFoundException {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid IngredientsForm form) {
		Ingredients saved = service.save(form);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(uri).body(saved);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Ingredients> list = service.findAll();
		List<IngredientsDto> listDto = list.stream()
				.map(item -> new IngredientsDto(item))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody IngredientsForm form) {
		Ingredients saved = service.update(id, form);
		return ResponseEntity.ok().body(saved);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
