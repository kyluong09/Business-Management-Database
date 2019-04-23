package com.spring.boot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.thymeleaf.dao.CustomerRepository;
import com.spring.boot.thymeleaf.dao.EmployeeRepository;
import com.spring.boot.thymeleaf.entity.Customer;
import com.spring.boot.thymeleaf.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	

	@Override
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}
	

	@Override
	public List<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		// Optional variable
		Optional<Employee> employee = employeeRepository.findById(id);
		// Temp employee var
		Employee tempEmployee;
		
		if(employee.isPresent()) {
			tempEmployee = employee.get();
			return tempEmployee;
		}else {
			throw new RuntimeException("Employee id is not found: "+ id);
		}
		

	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteById(int id) {
		// Check if employee is available 
		Optional<Employee> employee =  employeeRepository.findById(id);
		if(employee.isPresent()) {
			employeeRepository.deleteById(id);
		}else {
			throw new RuntimeException("Employee id is not found: "+ id);
		}


	}

}
