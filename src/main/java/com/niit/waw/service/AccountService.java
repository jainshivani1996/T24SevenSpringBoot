package com.niit.waw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.waw.model.Account;
import com.niit.waw.model.Customer;
import com.niit.waw.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository repo;


	public void saveAccount(Account account)
	{
		repo.save(account);
	}
	public Account getAccount(int currentBalance) {
		return repo.findById(currentBalance).get();
	}
	public void updateCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
	}	
	public Account findByCustomerAccountNo(long accountNo) {
		return repo.findByAccountNo(accountNo);
	}
	public Account findByCustomerDebitCard(long debitCard) {
		// TODO Auto-generated method stub
		return repo.findByDebitCard(debitCard);
	}
		
}
