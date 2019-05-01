package com.business.management;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.business.management.dao.RoleRepository;
import com.business.management.entity.Role;
import com.business.management.entity.User;
import com.business.management.service.UserService;

@SpringBootApplication
public class MainApplication implements CommandLineRunner{
	private Logger log = Logger.getLogger(this.getClass().getName());
	

	
//	@Autowired
//	private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
	
	}
	
}
