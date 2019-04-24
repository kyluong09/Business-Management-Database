package com.spring.boot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.thymeleaf.dao.CustomerRepository;
import com.spring.boot.thymeleaf.dao.ProductRepository;
import com.spring.boot.thymeleaf.entity.Customer;
import com.spring.boot.thymeleaf.entity.Employee;
import com.spring.boot.thymeleaf.entity.Product;

@Service
public class ServiceImpl implements CrudService {

	/**
	 * Customer Repository
	 */
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Product Repository
	 */
	@Autowired
	private ProductRepository productRepository;

	// FIND ALL

	@Override
	public List<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}

	// FIND BY ID

	@Override
	public Customer findCustomerById(int id) {
		// Optional variable
		Optional<Customer> customer = customerRepository.findById(id);
		// Temp employee var
		Customer tempCustomer;

		if (customer.isPresent()) {
			tempCustomer = customer.get();
			return tempCustomer;
		} else {
			throw new RuntimeException("Customer id is not found: " + id);
		}

	}
	
	// FIND BY NAME
	
	@Override
	public List<Customer> findCustomerByNAME(String name) {
		String tempName = name.trim();
		return customerRepository.findByName(tempName);
	}

	@Override
	public List<Product> findProductByName(String name) {
		return productRepository.findByName(name);
	}

	
	
	
	@Override
	public Product findProductById(int id) {
		// Optional variable
		Optional<Product> product = productRepository.findById(id);
		// Temp employee var
		Product tempProduct;
		
		if(product.isPresent()) {
			tempProduct = product.get();
			return tempProduct;
		}else {
			throw new RuntimeException("Product id is not found: "+ id);
		}
		

	}
	
	// SAVE
	
	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);

	}
	
	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);

	}

	// DELETE
	
	@Override
	public void deleteCustomerById(int id) {
		// Check if employee is available
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			customerRepository.deleteById(id);
		} else {
			throw new RuntimeException("Customer id is not found: " + id);
		}

	}
	
	@Override
	public void deleteProductById(int id) {
		// Check if employee is available
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.deleteById(id);
		} else {
			throw new RuntimeException("Product id is not found: " + id);
		}

	}
	
	
	
	

}
