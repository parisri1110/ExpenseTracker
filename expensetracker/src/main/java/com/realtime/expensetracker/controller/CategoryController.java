package com.realtime.expensetracker.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realtime.expensetracker.model.Category;
import com.realtime.expensetracker.repository.CategoryRepository;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	

	/*
	 * public CategoryController(CategoryRepository categoryRepository) { super();
	 * this.categoryRepository = categoryRepository; }
	 */
	
	@GetMapping("/welcome")
	public String welcomePage()
	{
		return "Welcome to Product page ";
	}
	
	@GetMapping("/categories")
	public List<Category> getCategories()
	{
		return categoryRepository.findAll();
		
	}
	
	@GetMapping("/category/{id}")
	ResponseEntity<?> getCategory(@PathVariable Integer id)
	{
		Optional<Category> category=categoryRepository.findById(id);
		return category.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/category")
	ResponseEntity<Category> addCategory(@RequestBody Category category) throws URISyntaxException
	{
		Category result=categoryRepository.save(category);
		return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
		
	}
	
	@PutMapping("/category/{id}")
	ResponseEntity<Category> updateCategoyr(@RequestBody Category category)
	{
		Category result=categoryRepository.save(category);
		return ResponseEntity.ok().body(result);
	}
	
	
	@DeleteMapping("/category/{id}")
	ResponseEntity<?> deleteCategory(@PathVariable Integer id)
	{
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	
}
