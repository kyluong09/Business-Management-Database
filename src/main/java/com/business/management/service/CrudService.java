package com.business.management.service;

import java.util.List;

import com.business.management.entity.Customer;
import com.business.management.entity.Product;
import com.business.management.entity.User;

public interface CrudService {
	

	// FIND ALL
	public List<Customer> findAllCustomer();
	public List<Product> findAllProduct();

	// FIND BY ID
	public Customer findCustomerById(int id);
	public Product findProductById(int id);
	
	// FIND BY NAME
	public List<Customer> findCustomerByNAME(String name);
	public List<Product> findProductByName(String name);

	// CREATE 
	public void saveCustomer(Customer customer);
	public void saveProduct(Product product);

	
	// DELETE
	public void deleteCustomerById(int id);
	public void deleteProductById(int id);

	
	

}
