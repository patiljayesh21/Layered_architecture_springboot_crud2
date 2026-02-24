package com.springbootcrudapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springbootcrudapi.util.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ApiResponse> handleNotFound(ResourceNotFoundException ex) {
	        return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body(new ApiResponse(false, ex.getMessage()));
	    }

}
