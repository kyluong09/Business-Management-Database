package com.spring.boot.thymeleaf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.thymeleaf.entity.Employee;
import com.spring.boot.thymeleaf.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	
	/**
	 * Show All Employees
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String showListEmployees(Model model) {
		List<Employee> employees = service.findAllEmployee();
		model.addAttribute("employees",employees);
		
		
		return "employees/list-employees";
		
		
		
	}
	
	/**
	 * Create/save new employee
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public String showEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		
		
		return "employees/employee-form";
		
		
		
	}
	
	/**
	 * Update employee by id and send model to /form path
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/formupdate")
	public String showEmployeeFormUpdate(@RequestParam("id") int id, Model model) {
		Employee employee = service.findById(id);
		
		model.addAttribute("employee",employee);
		
		
		return "employees/employee-form";
		
		
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		if(employee != null) {
			service.save(employee);
		}
		
		
		
		return "redirect:/employees/list";
		
		
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		service.deleteById(id);
		
		return "redirect:/employees/list";
		
		
		
	}

}
