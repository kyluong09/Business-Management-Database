package com.spring.boot.thymeleaf.service;

import java.util.List;

import com.spring.boot.thymeleaf.entity.Customer;
import com.spring.boot.thymeleaf.entity.Employee;
import com.spring.boot.thymeleaf.entity.Product;

public interface CrudService {
	
	// FIND ALL
	public List<Customer> findAllCustomer();
	public List<Product> findAllProduct();

	// FIND BY ID
	public Customer findCustomerById(int id);
	public Product findProductById(int id);

	// CREATE 
	public void saveCustomer(Customer customer);
	public void saveProduct(Product product);

	
	// DELETE
	public void deleteCustomerById(int id);
	public void deleteProductById(int id);

	
	

}
