package com.niit.waw.controller;


import java.util.Random;

//import java.sql.Date;
//import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.waw.model.Account;
//import com.niit.waw.model.Account;
import com.niit.waw.model.Customer;
import com.niit.waw.repository.CustomerRepository;
import com.niit.waw.service.AccountService;

@Controller
public class CustomerController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerRepository customerRepo;
	
	//mapping to register form
	@RequestMapping("/customer/regForm")
	public String showFormForAdd(ModelMap theModel)
	{
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "addCustomer";
	}


	//customer registration
	@RequestMapping("/customer/saveCustomer")
	public String saveCustomer(HttpServletRequest req,@ModelAttribute("customer") Customer theCustomer,Model model) {
		String search=req.getParameter("customerId"); 
		String phone=req.getParameter("phoneNo");
		String email=req.getParameter("email");// ID of the Car
		boolean exists = customerRepo.existsByCustomerId(search);
		boolean exist=customerRepo.existsByPhoneNo(phone);
		boolean e=customerRepo.existsByEmail(email);
		
		
		Random r = new Random();
		String temp="";
		temp+=String.valueOf(r.nextInt(999999));
		temp+=String.valueOf(r.nextInt(999999));
		long acNo = Long.parseLong(temp);		

		String str="";
		str+=String.valueOf(r.nextInt(99999999));
		str+=String.valueOf(r.nextInt(99999999));
		long debitNo=Long.parseLong(str);
		String acType = req.getParameter("accountType");
		String bn = req.getParameter("branchName");
		//String ifsc = req.getParameter("ifscCode");
		//int cb = Integer.parseInt(req.getParameter("currentBalance"));
int cvv=(r.nextInt(999));
		Account ac = new Account();
		ac.setAccountNo(acNo);
		ac.setAccountType(acType);
		ac.setBranchName(bn);
		ac.setIfscCode("T24S12345");
		ac.setCurrentBalance(0);
		ac.setCreditStatus("false");
		ac.setPin(0000);
		ac.setDebitCard(debitNo);
		ac.setCvv(cvv);
		ac.setCustomer(theCustomer);
		if(exists==true ) {
			model.addAttribute("msg","<script>alert('Customer Id already exists')</script>");
			return "addCustomer";
		}
		else if(exist==true ) {
			model.addAttribute("msg","<script>alert('Phone No already exists')</script>");
			return "addCustomer";
		}
		else if(e==true ) {
			model.addAttribute("msg","<script>alert('Email id already exists')</script>");
			return "addCustomer";
		}
		else if(exists==true && exist==true) {
			model.addAttribute("msg","<script>alert('Customer Id and phone no already exists')</script>");
			return "addCustomer";
		}
		else if(exists==true && e==true) {
			model.addAttribute("msg","<script>alert('Customer Id and email id already exists')</script>");
			return "addCustomer";
		}
		else if(exist==true && e==true) {
			model.addAttribute("msg","<script>alert('Phone no and email id already exists')</script>");
			return "addCustomer";
		}
		else if(exist==true && e==true && exists==true) {
			model.addAttribute("msg","<script>alert('Customer Id,Phone no and email id already exists')</script>");
			return "addCustomer";
		}
		else {
		accountService.saveAccount(ac);
		//customerService.saveCustomer(theCustomer);
		model.addAttribute("message", "<script>alert('Registered successfully')</script>");
		return "redirect:/user/loginForm";
		}
		
	
	}
	//mapping to customer dashboard
	@RequestMapping("/customer/customerDashboard")
	public String showCustomerPage(HttpServletRequest req,ModelMap theModel)
	{
		if(req.getSession(false)!=null && req.getSession(false).getAttribute("user")!=null) {
			
			return "customerDashboard";
		}
		else
		{
			return "login";
		}
			
	}

}
