package com.spring.boot.thymeleaf.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.boot.thymeleaf.dao.EmployeeRepository;
import com.spring.boot.thymeleaf.entity.Employee;
import com.spring.boot.thymeleaf.exception.NotFoundException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RepositoryRestController
public class RestRepoController {
	
	@Autowired
	private EmployeeRepository repo;
	
	
	@GetMapping("/employees/{id}")
	@ResponseBody
	public ResponseEntity<?> findAll(@PathVariable int id) {
		
		Optional<Employee> emp = repo.findById(id);

		if(!emp.isPresent()) {
			
			throw new NotFoundException("Not Found");
			
		}
		Resource<Employee> resource = new Resource<Employee>(emp.get());
        resource.add(linkTo(methodOn(RestRepoController.class).findAll(id)).withSelfRel()); 
        return ResponseEntity.ok(resource);

		
		
	}
	
	
	

	
	

	
	

}
