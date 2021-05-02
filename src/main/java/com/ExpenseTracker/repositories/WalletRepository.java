package com.ExpenseTracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExpenseTracker.entities.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long>{
	List<Wallet> findAllByOrderByPriority();
}
