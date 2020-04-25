package com.niit.waw.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.waw.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	public User findByCustomerId(String customerId);

	public void deleteByCustomerId(String customerId);

	public boolean existsByCustomerId(String customerId);





	//public boolean existsByCustomerId(String customerId);
}
