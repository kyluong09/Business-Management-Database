package com.business.management.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanWrapperImpl;
/**
 * 
 * @author kyluong09
 *
 */
public class FieldMatchConstraint implements ConstraintValidator<FieldMatch, Object> {
	private Logger log = Logger.getLogger(this.getClass().getName());
	
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
			final Object firstValue = new BeanWrapperImpl(value).getPropertyValue(firstParameter);
			final Object secondValue = new BeanWrapperImpl(value).getPropertyValue(secondParameter);
			
			
            if(!firstValue.equals(secondValue)) {
            	valid = false;
            }
            	
            
			
		}catch(final Exception e) {
			
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
