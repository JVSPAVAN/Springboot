package com.ilpbatch.siru.product.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(value="select * from TCS_Products where product_name like %:name%", nativeQuery=true)
	public List<Product> findByProductName(@Param("name") String name);	
	
}
