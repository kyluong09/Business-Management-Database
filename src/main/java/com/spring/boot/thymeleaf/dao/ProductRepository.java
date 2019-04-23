package com.spring.boot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.thymeleaf.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
