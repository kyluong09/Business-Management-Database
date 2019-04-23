package com.spring.boot.thymeleaf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.boot.thymeleaf.entity.ErrorResponse;

@RestControllerAdvice
public class RestExceptionHandler {
	
	/**
	 * Handler Not Found Exception
	 * @param e
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> notFoundHandler(NotFoundException e){
		
		// Create Error Object
		ErrorResponse error = new ErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * Handler Bad Request
	 * @param e
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> exceptionHanalder(Exception e){
		
		// Create Error Object
		ErrorResponse error = new ErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}

}
