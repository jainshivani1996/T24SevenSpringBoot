package com.niit.waw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.waw.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByCustomerId(String customerId);

	Customer deleteByCustomerId(String customerId);

	boolean existsByCustomerId(String search);

	boolean existsByPhoneNo(String phone);

	boolean existsByEmail(String email);
}
