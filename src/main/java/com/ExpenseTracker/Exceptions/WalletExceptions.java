package com.ExpenseTracker.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WalletExceptions extends RuntimeException {
	public WalletExceptions(String message) {
		super(message);
	}
}
