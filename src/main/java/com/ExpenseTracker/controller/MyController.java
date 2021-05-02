package com.ExpenseTracker.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseTracker.entities.Wallet;
import com.ExpenseTracker.services.ValidationErrorSevices;
import com.ExpenseTracker.services.WalletService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/wallet")
public class MyController {
	@Autowired
	private WalletService service;
	@Autowired
	private ValidationErrorSevices validationService;
	@PostMapping
	public ResponseEntity<?>create(@Valid @RequestBody Wallet wallet, BindingResult results){
		ResponseEntity errors = validationService.validate(results);
		if(errors==null) {
			Wallet saved = service.createOrUpdate(wallet);
			return new ResponseEntity<Wallet>(saved,HttpStatus.CREATED);
		}
		else
			return errors;		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?>update(@PathVariable Long id,@Valid @RequestBody Wallet wallet, BindingResult results){
		ResponseEntity errors = validationService.validate(results);
		if(errors==null) {
			wallet.setId(id);
			Wallet saved = service.createOrUpdate(wallet);
			return new ResponseEntity<Wallet>(saved,HttpStatus.OK);
		}
		else
			return errors;		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<?>getWallets(){
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>getWalletById(@PathVariable Long id){
		return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
	}
}
