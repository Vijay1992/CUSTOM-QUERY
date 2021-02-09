package com.query;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "products")
//@NamedQuery(name = "Product.findByPrice",query = "SELECT p from Product p where p.price between ?1 and ?2")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private float price;

	@Column(name = "email")
	private String email;
	
	@Column(name = "city")
	private String city;

	public Product() {
	}

	public Product(Integer id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
		
		
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", email=" + email + ", city=" + city
				+ "]";
	}

	// other getters and setters...

	
	
}