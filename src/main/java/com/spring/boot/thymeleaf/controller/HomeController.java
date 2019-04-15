package com.spring.boot.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String showHome(Model model) {
		
		model.addAttribute("date", new Date());
		
		
		return "home";
		
		
		
	}

}
