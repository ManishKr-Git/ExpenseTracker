package com.ExpenseTracker.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class ValidationErrorSevices {
	public ResponseEntity<?>validate(BindingResult result){
		if(result.hasErrors()) {
			Map<String,String>errorsMap = new HashMap<>();
			for(FieldError error:result.getFieldErrors()) {
				errorsMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errorsMap,HttpStatus.BAD_REQUEST);			
		}
		return null;
	}
}
