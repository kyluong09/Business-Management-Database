package com.business.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.management.entity.Customer;
import com.business.management.entity.Product;
import com.business.management.service.ServiceImpl;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	private ServiceImpl service;
	
	
	
	
	@GetMapping("")
	public String showDashboard(Model model) {
		
		List<Customer> customerList = service.findAllCustomer();
		List<Product> productList = service.findAllProduct();
		
		model.addAttribute("customerSize",customerList.size());
		model.addAttribute("productSize",productList.size());

		

		return "dashboard/dashboard";
	}

}
