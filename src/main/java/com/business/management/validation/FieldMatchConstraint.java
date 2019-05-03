package com.business.management.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;
/**
 * 
 * @author kyluong09
 *
 */
public class FieldMatchConstraint implements ConstraintValidator<FieldMatch, Object> {
	
	private String firstParameter;
	private String secondParameter;
	private String message;
	
	
	
	@Override
	public void initialize(FieldMatch constraintAnnotation) {
	
		firstParameter = constraintAnnotation.firstParameter();
		secondParameter = constraintAnnotation.secondParameter();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean valid = true;
		
		try {
			Object firstValue = new BeanWrapperImpl(value).getPropertyValue(firstParameter);
			Object secondValue = new BeanWrapperImpl(value).getPropertyValue(secondParameter);
			
            valid =  firstValue == null && secondValue == null || firstValue != null && firstValue.equals(secondValue);
			
		}catch(Exception e) {
			
		}
		
		
		if (!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(secondParameter)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

		
		
		return valid;
	}

}
