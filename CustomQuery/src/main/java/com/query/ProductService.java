package com.query;

import java.sql.Connection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository repo;

	public List<Product> getProductByName(String name) {
		return repo.getProductByName(name);
	}
	
	public List<Product> getProductPrice(float price){
		return repo.findByPrice(price);
	}

	public Product getProductByEmail(String email) {
		return repo.findByEmail(email);
	}

	public List<Product> getProductByCity(String city) {
		return repo.findByCity(city);
	}

	public String getProductNameByEmail(String email) {
		return repo.getProductNameByEmail(email);
	}
	
	public List<Product> getProductBetweenRange(float q1, float q2) {
		return repo.findByPrice(q1, q2);
	}

	public List<Product> listAll() {
		return repo.findAll();
	}

	public void save(Product product) {
		repo.save(product);
	}

	public Product get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public float getProductPriceByEmail(String email) {
		return repo.getProductPriceByEmail(email);
	}
	
	public int countRecords(String city) {
		return repo.countRecords(city);
	}
	
	public boolean existById(int id) {
		return repo.existsById(id);
	}
	
}