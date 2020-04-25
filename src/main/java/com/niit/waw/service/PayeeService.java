package com.niit.waw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.waw.model.Customer;
import com.niit.waw.model.Payee;
import com.niit.waw.model.Transaction;
import com.niit.waw.repository.CustomerRepository;
import com.niit.waw.repository.PayeeRepository;

@Service
@Transactional
public class PayeeService {
	@Autowired
	private PayeeRepository repo;
	
	public void savePayee(Payee payee)
	{
		repo.save(payee);
	}
	public List<Payee> findAllByPayeeAccountNo(Long accountNo){
		return repo.findAllByAccountNo(accountNo);
	}
	public void deletePayee(int beneficiaryId) {
		// TODO Auto-generated method stub
		repo.deleteById(beneficiaryId);
		
	}
}
