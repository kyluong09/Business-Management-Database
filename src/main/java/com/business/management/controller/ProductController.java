package com.business.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	
	@GetMapping("/product")
	public String showCustomer() {
		return "product/product";
	}

}
