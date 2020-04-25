package com.niit.waw.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.niit.waw.model.Account;
import com.niit.waw.model.Customer;
import com.niit.waw.model.CustomerList;
import com.niit.waw.model.User;
import com.niit.waw.repository.AccountRepository;
import com.niit.waw.repository.CustomerRepository;
import com.niit.waw.repository.UserRepository;
import com.niit.waw.service.AccountService;
import com.niit.waw.service.CustomerService;
import com.niit.waw.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class CustomerRestController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	AccountService aservice;
	
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	AccountRepository arepo;
	
	@Autowired
	UserService userService;
	@Autowired
	UserRepository urepo;
	
	@GetMapping("/customers") 
	public List<CustomerList> displayCustomerList(Customer c1)
	{
		List<Customer> list = service.listAllCustomer();
		
		List<CustomerList> cl = new ArrayList<CustomerList>();
		
		for(Customer c: list)
		{

			CustomerList customerList = new CustomerList();
			customerList.setCustomerId(c.getCustomerId());
			customerList.setFirstName(c.getFirstName());
			customerList.setLastName(c.getLastName());
			customerList.setEmail(c.getEmail());
			
			cl.add(customerList);
		}
		
		return cl;
	}
	
	
	@GetMapping("/customers/{customerId}")
	public CustomerList displayIndividualCustomerList(@PathVariable(value = "customerId") String customerId)
	{
		
		Customer c = service.findByCustomerId(customerId);
			CustomerList customerList = new CustomerList();
			customerList.setCustomerId(c.getCustomerId());
			customerList.setFirstName(c.getFirstName());
			customerList.setLastName(c.getLastName());
			customerList.setEmail(c.getEmail());
			
		return customerList;
	}
	
	 @DeleteMapping("/customers/{customerId}")
	    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "customerId") String customerId) 
	   {
		 User usr = userService.findByUserCustomerId(customerId);
		 //arepo.DeleteByCustomerId(customerId);
		 	//System.out.println(customer);
			//arepo.DeleteByCustomerId(customerId);
	        urepo.delete(usr);
	        
	        Map<String, Boolean> response = new HashMap<>();
			return response;
	 }
 
	 @PostMapping("/login")
		public Object login(@Valid @RequestBody User theUser) {
			User usr = userService.checkUser(theUser);
			if (usr == null) {
				return null;
			} 
			else if(usr.getRole().equalsIgnoreCase("A"))

			{
				return usr;
			}
			return null;
	 }
}