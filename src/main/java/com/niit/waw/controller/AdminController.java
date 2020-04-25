package com.niit.waw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.waw.model.Customer;
import com.niit.waw.service.CustomerService;


@Controller
public class AdminController {
	@Autowired
	private CustomerService customerService;

	
	//displaying customer list to the admin
	@RequestMapping("/customer/list")
	public String viewHomePage(Model model)
	{
		List<Customer> listCustomers = customerService.listAllCustomer();
		model.addAttribute("listCustomers", listCustomers);
		return "adminDashboard";
	}
}
