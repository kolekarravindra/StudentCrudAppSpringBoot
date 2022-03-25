package com.example.demo.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalException {
	
	// Custom global Exception
	
	  @ExceptionHandler(Exception.class) 
	  public ResponseEntity<String> handleInputEntity(Exception exception){
	  
	  return new ResponseEntity<String>("Input field is Empty,Plese look into it",HttpStatus.BAD_REQUEST); }
	 
	 
	  @ExceptionHandler(Exception.class) 
	  public ResponseEntity<String> NoSuchElementPresent(Exception exception){
	  
	  return new ResponseEntity<String>("Input field is Empty,Plese look into it",HttpStatus.BAD_REQUEST); }
	 
	  
	/*@ExceptionHandler(ErrorDetails.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
	
	
}



