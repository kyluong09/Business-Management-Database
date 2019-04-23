package com.spring.boot.thymeleaf.service;

import java.util.List;

import com.spring.boot.thymeleaf.entity.Customer;
import com.spring.boot.thymeleaf.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAllEmployee();
	
	public List<Customer> findAllCustomer();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
	
	

}
