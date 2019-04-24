package com.spring.boot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.thymeleaf.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE LOWER(p.productName) = LOWER(:name)")
	public List<Product> findByName(@Param("name")String name);
}
