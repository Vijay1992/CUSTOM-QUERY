package com.query;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/products")
	public List<Product> list() {
		return service.listAll();
	}

	//RESTful API to get product based on email
	@GetMapping("/products2/{email}")
	public Product getProductByEmail(@PathVariable String email) {
		return service.getProductByEmail(email);
	}
	
	@GetMapping("/products3/{city}")
	public List<Product> getProductByCity(@PathVariable String city) {
		return service.getProductByCity(city);
	}
	
	///RESTful api to get product price
	@GetMapping("/product5/{price}")
	public List<Product> getProductPrice(@PathVariable float price){
		  return service.getProductPrice(price);
		 }
	
	  //RESTful api to get product between price range
	  
	  @GetMapping("/products4/{q1}/{q2}")
	  public List<Product> getProductBetweenRange(@PathVariable float q1,@PathVariable float q2){
	  return service.getProductBetweenRange(q1, q2); }
	 
	
	
	// RESTful API to get Product based on Product-Name
	@GetMapping("/products1/{byName}")
	public List<Product> getProductByName(@PathVariable("byName") String name) {
			return (List<Product>) service.getProductByName(name);
	}

	
	// RESTFul API to get info about specific product by email
	@GetMapping("/products6/{email}")
	public String getProductNameByEmail(@PathVariable("email") String email) {
			return service.getProductNameByEmail(email);
	}
	
	// RESTFul API to get info about specific product by email
		@GetMapping("/products7/{email}")
		public float getProductPriceByEmail(@PathVariable("email") String email) {
				return service.getProductPriceByEmail(email);
		}
	
	
	
	// RESTFul API to get info about specific product
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		try {
			Product product = service.get(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/products")
	public void add(@RequestBody Product product) {
		service.save(product);
	}

	// RESTful API method for Update operation
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		try {
		//	Product existProduct = service.get(id);
			service.save(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@GetMapping("pro1/{city}")
	public int countRecords(@PathVariable("city")String city) {
		return service.countRecords(city);
	}
	
	@GetMapping("pro2/{id}")
	public boolean existById(@PathVariable("id")int id) {
		return service.existById(id);
	}
}