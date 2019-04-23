package com.spring.boot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.thymeleaf.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
