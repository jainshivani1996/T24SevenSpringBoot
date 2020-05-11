package com.niit.waw.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.waw.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{



List<Transaction> findAllByAccountNo(Long accountNo);
//List<Transaction> findAllByAccountNoOrderByTransDate(Long accountNo);

List<Transaction> findAllByAccountNoOrderByTransDateDesc(Long accountNo);
//List<Transaction> findTop10OrderByTransDateDesc(Long accountNo);

Transaction findFirstByAccountNoOrderByTransDateDesc(Long accountNo);
}


