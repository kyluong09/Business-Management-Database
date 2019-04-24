package com.business.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.business.management.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	@Query("SELECT c FROM Customer c WHERE CONCAT(LOWER(c.firstName),' ',LOWER(c.lastName)) LIKE LOWER(concat('%',:name,'%'))")
	public List<Customer> findByName(@Param("name") String name);
	
	

}
