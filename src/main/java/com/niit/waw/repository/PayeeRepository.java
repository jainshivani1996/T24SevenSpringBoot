package com.niit.waw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.waw.model.Payee;

public interface PayeeRepository extends JpaRepository<Payee, Integer>{

	List<Payee> findAllByAccountNo(Long accountNo);



	boolean existsByPayeeAccount(long search);

}
