package com.niit.waw.controller;

import java.util.Base64;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.waw.model.Account;
import com.niit.waw.model.Customer;

import com.niit.waw.model.User;
import com.niit.waw.repository.AccountRepository;
import com.niit.waw.repository.CustomerRepository;
import com.niit.waw.service.AccountService;
import com.niit.waw.service.CustomerService;
import com.niit.waw.service.UserService;


@Controller
public class UpdationController {

	@Autowired
	CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@Autowired
	UserService userService;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	AccountRepository repo;


	//Mapping to update email
	@GetMapping("/customer/updateCustomerEmail")
	public String updateEmail(HttpServletRequest req,Model model) {
	
			return "updateCustomerEmail";
		
	}


	//update personal detail
	@PostMapping("/customer/updateEmailDetail")
	public String updateEmail(HttpServletRequest req, @ModelAttribute("customer") Customer theCust,Model model) {

		User user  =  (User)req.getSession(false).getAttribute("user");
		Customer theCustomer = customerService.get(user.getCustomerId());

		String email=(req.getParameter("email"));
		String phoneNo=(req.getParameter("phoneNo"));
		if(email=="" && phoneNo!="") {
			boolean exist=customerRepo.existsByPhoneNo(phoneNo);

			if(exist) {
				model.addAttribute("msg","Phone No already exists");
				return "updateCustomerEmail";
			}
			else {
				theCustomer.setPhoneNo(phoneNo);
				accountService.updateCustomer(theCustomer);
				model.addAttribute("msg", "'Phone Number Updated SuccessFully");
				return "updateCustomerEmail";
			}
		}
		else if(email!="" && phoneNo=="") {
			boolean e=customerRepo.existsByEmail(email);
			if(e) {
				model.addAttribute("msg","Email Id already exists");
				return "updateCustomerEmail";
			}
			else {
				theCustomer.setEmail(email);
				accountService.updateCustomer(theCustomer);
				model.addAttribute("msg", "Email Updated SuccessFully");
				return "updateCustomerEmail";
			}
		}
		else if(email!="" && phoneNo!="") {
			boolean exist=customerRepo.existsByPhoneNo(phoneNo);

			boolean e=customerRepo.existsByEmail(email);
			if(e) {
				model.addAttribute("msg","Email Id already exists");
				return "updateCustomerEmail";
			}
			else if(exist) {
				model.addAttribute("msg","Phone No already exists");
				return "updateCustomerEmail";
			}
			else if(exist && e ){
				model.addAttribute("msg","Phone No and Email already exists");
				return "updateCustomerEmail";
			}
			else {
				theCustomer.setPhoneNo(phoneNo);
				theCustomer.setEmail(email);
				accountService.updateCustomer(theCustomer);

				model.addAttribute("msg", "Email Id and Phone Number Updated SuccessFully");
				return "updateCustomerEmail";
			}}
		else {

			model.addAttribute("msg", "No updates found");
			return "updateCustomerEmail";
		}

	}


	//Mapping to change password
	@GetMapping("/customer/updatePassword")
	public String updatePassword(HttpServletRequest req,Model model) {
	

			return "updateCustomerPassword";
	
	}

	//update password
	@PostMapping("/customer/updatePasswordDetails")
	public String updatePassword(HttpServletRequest req, @ModelAttribute("user") User theUser,Model model) {

		User user  =  (User)req.getSession(false).getAttribute("user");
		user.getCustomerId();
		String usr1=user.getPassword();

		String password=(req.getParameter("password"));
		String newPassword=(req.getParameter("confirmPassword"));

		Base64.Decoder decoder = Base64.getDecoder();  
		// Decoding string  
		String str = new String(decoder.decode(usr1));  
		if(str.equals(password)) {
			System.out.println(usr1);
			System.out.println(newPassword);
			user.setPassword(newPassword);
			userService.saveAndFlushUser(user);

			model.addAttribute("message", "Password Updated SuccessFully");
			return ("updateCustomerPassword");
		}
		else {

			model.addAttribute("message", "Password does not match");
			return ("updateCustomerPassword");

		}

	}


	//generate ATM pin
	@GetMapping("/customer/generatePin")
	public String generatePin(HttpServletRequest req,Model model) {
	
			return "generatePin";
		}
		

	@PostMapping("/customer/generatePinForm")
	public String generatePinForm(HttpServletRequest req,Model model)
	{

		User user=(User)req.getSession(false).getAttribute("user");

		Customer customer=customerService.get(user.getCustomerId());
		long ac=Long.parseLong(req.getParameter("accountNo"));
		long debit=Long.parseLong(req.getParameter("debitCard"));
		int cvv=Integer.parseInt(req.getParameter("cvv"));
		int pin=Integer.parseInt(req.getParameter("confirmPin"));
		long accountNo=customer.getAccount().getAccountNo();
		long debitCard=customer.getAccount().getDebitCard();
		int customerCvv=customer.getAccount().getCvv();
		if(ac==accountNo && debit==debitCard && cvv==customerCvv) {
			customer.getAccount().setPin(pin);
			accountService.updateCustomer(customer);
			model.addAttribute("message", "Pin changed");
			return "generatePin";
		}
		else {

			model.addAttribute("message", "Incorrect details");
			return "generatePin";
		}

	}



	//apply for credit card
	@RequestMapping("/customer/applyNow")
	public String applyNow(HttpServletRequest req,Model model)
	{
		
			User user=(User)req.getSession(false).getAttribute("user");

			Customer customer=customerService.get(user.getCustomerId());


			model.addAttribute("customer",customer);
			return "applyNow";
		
	}
	@PostMapping("/customer/applyCreditCard")
	public String applyCreditCard(HttpServletRequest req,Model model)
	{

		User user=(User)req.getSession(false).getAttribute("user");

		Customer customer=customerService.get(user.getCustomerId());
		String status=customer.getAccount().getCreditStatus();
		System.out.println(status);
		if(status.equalsIgnoreCase("false")) {
			customer.getAccount().setCreditStatus("true");
			String a=customer.getAccount().getCreditStatus();
			System.out.println(a);
			accountService.updateCustomer(customer);
			model.addAttribute("message","Card applied successfully");
			return "applyNow";}
		else {
			model.addAttribute("message","Already applied");
			return "applyNow";
		}


	}


	//add balance
	@RequestMapping("/customer/addBalance")
	public String addBalance(HttpServletRequest req,Model model)
	{
		
			return "addBalance";
		
	}
	@PostMapping("/customer/addAccountBalance")
	public String addAccountBalance(HttpServletRequest req,Model model)
	{
		User user=(User)req.getSession(false).getAttribute("user");

		Customer customer=customerService.get(user.getCustomerId());
		long debitCard=Long.parseLong(req.getParameter("debitCard"));
		int cvv=Integer.parseInt(req.getParameter("cvv"));
		int pin=Integer.parseInt(req.getParameter("pin"));
		boolean exists=repo.existsByDebitCard(debitCard);
		if(exists) {
			Account ac=accountService.findByCustomerDebitCard(debitCard);
			ac.getAccountNo();
			int currentBal=ac.getCurrentBalance();
			int custCvv=ac.getCvv();
			int custPin=ac.getPin();
			if(custCvv==cvv && custPin==pin) {
				int bal=Integer.parseInt(req.getParameter("currentBal"));

				if(bal<=currentBal) {
					int balance=bal+customer.getAccount().getCurrentBalance();
					customer.getAccount().setCurrentBalance(balance);
					int payerBalance=ac.getCurrentBalance()-bal;
					ac.setCurrentBalance(payerBalance);
					accountService.updateCustomer(customer);
					model.addAttribute("message","Transaction successful");
					return "addBalance";
				}
				else {
					model.addAttribute("message","Transaction failed");
					return "addBalance";
				}
			}
			else {
				model.addAttribute("message","Invalid pin or cvv");
				return "addBalance";
			}}
		else {
			model.addAttribute("message","Invalid debit card");
			return "addBalance";
		}
	}

}


