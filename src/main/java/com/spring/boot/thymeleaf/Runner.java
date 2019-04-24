package com.spring.boot.thymeleaf;


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

		
		
		
	
		
		
	}

}
