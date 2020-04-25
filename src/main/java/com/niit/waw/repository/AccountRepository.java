package com.niit.waw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.waw.model.Account;
import com.niit.waw.model.Transaction;

public interface AccountRepository extends JpaRepository<Account, String> {

	Optional<Account> findById(int currentBalance);
	Account findByAccountNo(long accountNo);
	boolean existsByAccountNo(long accountNo);
	boolean existsByIfscCode(String ifscCode);
	boolean existsByDebitCard(long debitCard);
	Account findByDebitCard(long debitCard);
	
	


}
