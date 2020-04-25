package com.niit.waw.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.waw.model.Customer;
import com.niit.waw.model.User;
import com.niit.waw.repository.UserRepository;


@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> listAllUser()
	{
		return repo.findAll();
	}

	public User getUser(String email)
	{
		return repo.findById(email).get();
	}

	public User checkUser(User user)
	{
		User temp = repo.findById(user.getCustomerId()).get();
		if(user.getCustomerId().equals(temp.getCustomerId())&&(user.getPassword()).equals(temp.getPassword()))
		{
			return temp;
		}
		else 
		{
			return null;
		}
	}
	

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}
	public void saveUser(User user)
	{
		repo.save(user);
	}
	public void deleteUser(String customerId) {
		// TODO Auto-generated method stub
		repo.deleteByCustomerId(customerId);
		
	}
	public boolean  isUser(String customerId)
	{
		return repo.existsByCustomerId(customerId);
	}

	

	public void saveAndFlushUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	public User findByUserCustomerId(String customerId)
		{
			return repo.findByCustomerId(customerId);				
		}
}
