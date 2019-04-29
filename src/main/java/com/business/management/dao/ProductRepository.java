package com.business.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.business.management.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p from Product p WHERE LOWER(p.productName) LIKE LOWER(:name) OR LOWER(p.brandName) LIKE LOWER(:name)")
	public List<Product> findByName(@Param("name") String name);
	
}
