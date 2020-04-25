package com.niit.waw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.waw.service.CustomerService;
import com.niit.waw.service.UserService;

@Controller
public class DeleteController {
	
	@Autowired
	CustomerService customerService;
	


	@Autowired
	UserService userService;
	
	//delete customer
	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam("customerId") String customerId) {
	userService.deleteUser(customerId);
	return "adminDashboard";
	}
}
