package com.business.management.validation;

import java.util.logging.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.business.management.entity.User;
import com.business.management.service.UserService;



public class UniqueUsernameConstraint implements ConstraintValidator<UniqueUsername,String> {
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private UserService userService;
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean valid = true;
		if(value != null) {
			try {
				User user = userService.findByUsername(value);
				if(user != null) valid = false;
			}catch(Exception e) {
				
			}
		
			
		}
		return valid;
	}

}
