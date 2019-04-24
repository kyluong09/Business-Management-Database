package com.business.management;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.business.management.entity.Address;
import com.business.management.entity.Customer;
import com.business.management.entity.Order;
import com.business.management.service.CrudService;

@Component
public class Runner  implements CommandLineRunner{
	
	@Autowired
	private CrudService service;

	@Override
	public void run(String... args) throws Exception {

		
		
		
	
		
		
	}

}
