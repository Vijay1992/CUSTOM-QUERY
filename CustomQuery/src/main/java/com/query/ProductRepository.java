package com.query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> 
{
	@Query("SELECT p.name from Product p where p.name=?1")
	public List<Product> getProductByName(String name);
	
	@Query( "select u from Product u where u.email = ?1")
	public Product findByEmail(String email);
	
	@Query("select u from Product u where u.city = ?1")
	public List<Product> findByCity(String city);
	
	
	@Query(value = "SELECT u from Product u WHERE u.price=?1",nativeQuery = false)
	  public List<Product> findByPrice(float price);

	
//	  @Query("SELECT u from Product u where u.price>=?1 and u.price<=?2")
	  @Query("SELECT u from Product u WHERE u.price between ?1 and ?2")
	  public List<Product> findByPrice(float q1,float q2);

	  @Query("select u.name from Product u where u.email=?1")
	  public String getProductNameByEmail(String email);
	  
	  @Query("select u.price from Product u where u.email=?1")
	  public float getProductPriceByEmail(String email);
	  
	  @Query("select count(u) from Product u where u.city=?1")
	  public int countRecords(String city);
}
