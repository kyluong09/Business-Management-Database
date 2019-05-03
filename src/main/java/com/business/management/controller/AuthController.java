package com.business.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.management.entity.User;
import com.business.management.service.UserService;
/**
 * 
 * @author kyluong09
 *
 */
@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Pre-process every string data
	 * Remove leading and trailing white space until null
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class,trimmer);
		
	}
	
	/**
	 * Show custom login page
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		
		return "auth/login";
		
	}
	
	/**
	 * Show custom sign up page
	 * @return
	 */
	@GetMapping("/sign-up")
	public String signUp(Model model) {
		// Create user object
		User user = new User();
		// Add  object into model
		model.addAttribute("user",user);
		return "/auth/sign-up";
	}
	
	
	@PostMapping("/process-sign-up")
	public String processSignUp(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		// Return to sign-up page if there's an error
		// Otherwise save user into database and go back to login page
		if(bindingResult.hasErrors()) {
			return "auth/sign-up";
		}else {
			// Save user
			userService.saveUser(user);
			return "redirect:/login";
			
		}
		
	
	}
	
	/**
	 * Show custom access denied page when user dont have permission to access a page
	 * @return
	 */
	@RequestMapping("/access-denied")
	public String accessException() {
		
		return "exception/access-denied";
		
	}

}
