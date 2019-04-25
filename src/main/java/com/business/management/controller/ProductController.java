package com.business.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.business.management.entity.Address;
import com.business.management.entity.Customer;
import com.business.management.entity.Product;
import com.business.management.service.ServiceImpl;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ServiceImpl service;

	@GetMapping("")
	public String showCustomer(Model model) {
		List<Product> productList = service.findAllProduct();

		model.addAttribute("productList", productList);

		return "product/product";
	}

	@GetMapping("/form")
	public String showForm(Model model) {

		// Create object
		Product product = new Product();
	
		model.addAttribute("product", product);

		return "product/product-form";
	}

	@GetMapping("/save")
	public String processSave(@ModelAttribute Product product) {

		if (product != null) {
			service.saveProduct(product);
		}

		return "redirect:/product";
	}
//	
//	@GetMapping("/update")
//	public String processUpdate(@RequestParam int id, Model model) {
//		// Get data from database
//		Customer customer = service.findCustomerById(id);
//
//		
//		model.addAttribute("customer",customer);
//		
//
//		return "customer/customer-form";
//	}
//	
//	@GetMapping("/search")
//	public String processSearch(@RequestParam("searchName") String searchName, Model model) {
//		// Get data from database
//		List<Customer> customerList = service.findCustomerByNAME(searchName);
//
//		
//		model.addAttribute("customerList",customerList);
//		
//
//		return "customer/customer";
//	}
//	
//	@GetMapping("/delete")
//	public String processDelete(@RequestParam int id) {
//
//		// Delete
//		service.deleteCustomerById(id);
//
//		return "redirect:/customer";
//	}

}
