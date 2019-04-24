package com.spring.boot.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.boot.thymeleaf.entity.Address;
import com.spring.boot.thymeleaf.entity.Customer;
import com.spring.boot.thymeleaf.entity.Order;
import com.spring.boot.thymeleaf.service.CrudService;

@Component
public class Runner  implements CommandLineRunner{
	
	@Autowired
	private CrudService service;

	@Override
	public void run(String... args) throws Exception {

		
		
		
		
		Customer customer = new Customer("ky","luong","12121",new Address());
		customer.addOrder(new Order());
		
		service.saveCustomer(customer);
		
	
		
		
	}

}
