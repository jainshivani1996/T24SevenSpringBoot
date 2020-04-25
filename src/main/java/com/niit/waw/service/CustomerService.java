package com.niit.waw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.waw.model.Customer;
import com.niit.waw.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository repo;



	public void saveCustomer(Customer customer)
	{
		repo.save(customer);
	}

	public Customer listOneCustomer(String customerId)
	{
		return repo.findByCustomerId(customerId);
	}

	public List<Customer> listAllCustomer()
	{
		return repo.findAll();
	}

	public Customer getCustomer(String customerId)
	{
		return repo.findByCustomerId(customerId);
	}
	public Customer findByCustomerId(String customerId)
	{
		return repo.findByCustomerId(customerId);
	}


	//update
	public Customer get(String customerID)
	{
		return repo.findByCustomerId(customerID);
	}

	/*public Customer findByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}*/

	public void deleteCustomer(String customerId)
	{
		repo.deleteById(customerId);
	}

	public void updateCust(Customer customerId)
	{
		//sarepo.deleteByStudentId(student.getId());
		repo.save(customerId);
	}
	
	public Customer checkCustomer(Customer cust)
	{
		Customer temp = repo.findByCustomerId(cust.getCustomerId());
		if(cust.getCustomerId().equals(temp.getCustomerId()))
		{
			return temp;
		}
		else 
		{
			return null;
		}
	}
}

