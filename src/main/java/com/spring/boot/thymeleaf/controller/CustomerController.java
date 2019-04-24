package com.spring.boot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.thymeleaf.entity.Address;
import com.spring.boot.thymeleaf.entity.Customer;
import com.spring.boot.thymeleaf.service.ServiceImpl;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private ServiceImpl service;

	@GetMapping("")
	public String showCustomer(Model model) {
		List<Customer> customerList = service.findAllCustomer();

		model.addAttribute("customerList", customerList);

		return "customer/customer";
	}

	@GetMapping("/form")
	public String showForm(Model model) {

		// Create object
		Customer customer = new Customer();
		Address address = new Address();

		model.addAttribute("customer", customer);

		return "customer/customer-form";
	}

	@GetMapping("/save")
	public String processSave(@ModelAttribute Customer customer) {

		if (customer != null) {
			service.saveCustomer(customer);
		}

		return "redirect:/customer";
	}
	
	@GetMapping("/update")
	public String processUpdate(@RequestParam int id, Model model) {
		// Get data from database
		Customer customer = service.findCustomerById(id);

		
		model.addAttribute("customer",customer);
		

		return "customer/customer-form";
	}
	
	@GetMapping("/search")
	public String processSearch(@RequestParam("searchName") String searchName, Model model) {
		// Get data from database
		List<Customer> customerList = service.findCustomerByNAME(searchName);

		
		model.addAttribute("customerList",customerList);
		

		return "customer/customer";
	}
	
	@GetMapping("/delete")
	public String processDelete(@RequestParam int id) {

		// Delete
		service.deleteCustomerById(id);

		return "redirect:/customer";
	}

}
