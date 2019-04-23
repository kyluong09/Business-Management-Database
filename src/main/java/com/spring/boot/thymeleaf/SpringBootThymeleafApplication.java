package com.spring.boot.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.boot.thymeleaf.entity.Customer;
import com.spring.boot.thymeleaf.service.CrudService;
import com.spring.boot.thymeleaf.service.ServiceImpl;

@SpringBootApplication
public class SpringBootThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeleafApplication.class, args);
		
		
	}
	
	

}
