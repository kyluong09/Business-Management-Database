package com.business.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.business.management.entity.Customer;
import com.business.management.service.CrudService;
import com.business.management.service.ServiceImpl;

@SpringBootApplication
public class SpringBootThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeleafApplication.class, args);
		
		
	}
	
	

}
