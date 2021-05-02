package com.ExpenseTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ExpenseTracker.Exceptions.WalletExceptions;
import com.ExpenseTracker.entities.Wallet;
import com.ExpenseTracker.repositories.WalletRepository;

@Service
public class WalletService {
	@Autowired
	WalletRepository repository;
	public Wallet createOrUpdate(Wallet wallet) {
		repository.save(wallet);
		return wallet;
	}
	public boolean delete(Long id) {
		Optional<Wallet>wallet = repository.findById(id);
		if(wallet.isPresent()) {
			repository.delete(wallet.get());
			return true;
		}
		throw new WalletExceptions("Wallet with id "+id+" does not exist");		
	}
	public Wallet getById(Long id) {
		Optional<Wallet> wallet = repository.findById(id);
		if(wallet.isPresent()) {
			return wallet.get();
		}
		throw new WalletExceptions("Wallet with id "+id+" does not exist");
	}
	public List<Wallet>getAll(){
		return repository.findAllByOrderByPriority();
	}
}
