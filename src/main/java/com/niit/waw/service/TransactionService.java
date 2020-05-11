package com.niit.waw.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.waw.model.Transaction;
import com.niit.waw.repository.TransactionRepository;
@Service
@Transactional
public class TransactionService {

	@Autowired
	private TransactionRepository transRepo;


	public List<Transaction> findAllByTransAccountNo(Long accountNo){
		return transRepo.findAllByAccountNo(accountNo);
	}


	public List<Transaction> findAllByAccountNoOrderByTransDateDesc(long accountNo) {
		return transRepo.findAllByAccountNoOrderByTransDateDesc(accountNo);
	}
	public Transaction findFirstByAccountNoOrderByTransDateDesc(long accountNo) {
		return transRepo.findFirstByAccountNoOrderByTransDateDesc(accountNo);
	}

}
