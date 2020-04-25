package com.niit.waw.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.waw.model.Customer;
import com.niit.waw.model.User;
import com.niit.waw.service.CustomerService;


@Controller
public class DisplayController {
	@Autowired
	private CustomerService customerService;

	
	//display account balance
	@RequestMapping("/user/account")
	public String showaccountDetails(HttpServletRequest req,Model model)
	{
		
			User user=(User)req.getSession(false).getAttribute("user");

			Customer customer=customerService.get(user.getCustomerId());
			String s=customer.getCustomerId();
			Customer cust=customerService.findByCustomerId(s);
			int accountBal=cust.getAccount().getCurrentBalance();
			model.addAttribute("accountDetail",accountBal);
		
		return "customerDashboard";
	}


	//display profile of the logged in user
	@RequestMapping("/user/profile")
	public String showaccountProfile(HttpServletRequest req,Model model)
	{
		
			User user=(User)req.getSession(false).getAttribute("user");
			Customer customer=customerService.get(user.getCustomerId());
			String s=customer.getCustomerId();
			Customer cust=customerService.findByCustomerId(s);
			int accountBal=cust.getAccount().getCurrentBalance();
			String ifsc=cust.getAccount().getIfscCode();
			String branch=cust.getAccount().getBranchName();
			long accNo=cust.getAccount().getAccountNo();
			long debitNo=cust.getAccount().getDebitCard();
			String firstName=cust.getFirstName();
			String lastName=cust.getLastName();
			model.addAttribute("firstName",firstName) ;
			model.addAttribute("lastName",lastName) ;
			model.addAttribute("accountBal",accountBal) ;
			model.addAttribute("ifsc",ifsc);
			model.addAttribute("branch",branch);
			model.addAttribute("accNo",accNo);
			model.addAttribute("debitNo",debitNo);
		
		return "profileDisplay";
	}
}
