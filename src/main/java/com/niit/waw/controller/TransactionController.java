package com.niit.waw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import com.niit.waw.model.Account;
import com.niit.waw.model.Customer;
import com.niit.waw.model.Payee;
import com.niit.waw.model.Transaction;
import com.niit.waw.model.User;
import com.niit.waw.repository.AccountRepository;
import com.niit.waw.repository.CustomerRepository;
import com.niit.waw.repository.PayeeRepository;
import com.niit.waw.service.AccountService;
import com.niit.waw.service.CustomerService;
import com.niit.waw.service.PayeeService;
import com.niit.waw.service.TransactionService;
import com.niit.waw.service.UserService;

@Controller
public class TransactionController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	UserService userService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	PayeeService payeeService;
	

	@Autowired
	PayeeRepository payeeRepo;

	@Autowired
	AccountRepository accountRepo;
	@Autowired
	CustomerRepository custRepo;
	
	//generate detailed statement
	@RequestMapping("/customer/miniStatement")
	public String generateMiniStatement(HttpServletRequest req,Model model)
	{
		User user=(User)req.getSession(false).getAttribute("user");

			Customer customer=customerService.get(user.getCustomerId());
			String s=customer.getCustomerId();
			Customer cust=customerService.findByCustomerId(s);
			long acc=cust.getAccount().getAccountNo();
			List<Transaction> listTransactions=transactionService.findAllByTransAccountNo(acc);
			model.addAttribute("listTransactions",listTransactions);
		
		return "miniStatement";
	}
	
	
	//get mini statement
	@RequestMapping("/customer/miniStatementShort")
	public String generateMiniStatementShort(HttpServletRequest req,Model model)
	{
		
			User user=(User)req.getSession(false).getAttribute("user");

			Customer customer=customerService.get(user.getCustomerId());
			String s=customer.getCustomerId();
			Customer cust=customerService.findByCustomerId(s);
		
			long acc=cust.getAccount().getAccountNo();
			List<Transaction> listTransactions=transactionService.findAllByAccountNoOrderByTransDateDesc(acc);
			model.addAttribute("listTransactions",listTransactions);
		
		return "miniStatementShort";
	}


	//get payee list
	@RequestMapping("/customer/getPayee")
	public String getPayee(HttpServletRequest req,Model model)
	{
	
			User user=(User)req.getSession(false).getAttribute("user");

			Customer customer=customerService.get(user.getCustomerId());
	
		
			long acc=customer.getAccount().getAccountNo();
			List<Payee> listTransactions=payeeService.findAllByPayeeAccountNo(acc);
			model.addAttribute("listTransactions",listTransactions);
		
		return "getPayeeList";
	}
	
	
	//mapping to fund transfer via account
	@GetMapping("/customer/depositBalance")
	public String depositBalance(HttpServletRequest req,Model model) {
		
		
			return "depositBalance";
		
	}
	
	//mapping to adding beneficiary page
	@RequestMapping(value ="/customer/transfer",  method = {RequestMethod.POST, RequestMethod.GET})
	public String transfer(@RequestParam("payeeAccount") long payeeAccount,HttpServletRequest req,Model model) {
		
	
			return "depositAccountBalance";
		
		
	}
	
	
	
	@RequestMapping(value = "/customer/depositBalanceAccount",  method = {RequestMethod.POST, RequestMethod.GET})
	public String depositBalance(HttpServletRequest req, @ModelAttribute("customer") Customer theCust, Account account,Model model) {
	
			User user  =  (User)req.getSession(false).getAttribute("user");
			Customer theCustomer = customerService.get(user.getCustomerId());
			long accNo1=Long.parseLong(req.getParameter("accountNo"));
			String ifsc1=req.getParameter("ifscCode");
			String search2=ifsc1;
			long search1=accNo1;
			boolean exists1=accountRepo.existsByAccountNo(search1);
			boolean exists2=accountRepo.existsByIfscCode(search2);
			if(!exists1) {
				
				model.addAttribute("msg", "Invalid Account Number");
				return "depositBalance";
			}
			else if(exists1 && !exists2) {
				
				model.addAttribute("msg", "Invalid Ifsc Code");
				return "depositBalance";
			}
			//Account acc=accountService.checkAccount(account); 
			else {
				//Account ac=acc;
				long acNo=theCustomer.getAccount().getAccountNo();
				long accNo=Long.parseLong(req.getParameter("accountNo"));
				String ifsc = req.getParameter("ifscCode");
				String name=req.getParameter("name");
				Payee pay = new Payee();
				pay.setAccountNo(acNo);
				pay.setPayeeAccount(accNo);
				pay.setNickName(name);
				pay.setPayeeIfsc(ifsc);
				long search=accNo; // ID of the Car
				boolean exists = payeeRepo.existsByPayeeAccount(search);
				if(exists) {
					
							model.addAttribute("msg","Payee already exists");
							return "depositBalance";
				}
				else {
				payeeService.savePayee(pay);
				model.addAttribute("msg","Payee added successfully");
				return "depositBalance";
				
				}
				
			}}
			
	
		

	@RequestMapping(value ="/customer/depositAmount",  method = {RequestMethod.POST, RequestMethod.GET})
	public String depositAmount(HttpServletRequest req, @ModelAttribute("customer") Customer theCust, @ModelAttribute("account") Account account, @ModelAttribute("payee") Payee payee,Model model) {
		User user  =  (User)req.getSession(false).getAttribute("user");
			Customer theCustomer = customerService.get(user.getCustomerId());
			
			long accNo=Long.parseLong(req.getParameter("ac"));
			
			Account acc=accountService.findByCustomerAccountNo(accNo);
			System.out.println(acc.getCurrentBalance());
			int currentBal=Integer.parseInt(req.getParameter("balance"));
			
			if(theCustomer.getAccount().getCurrentBalance()>=currentBal) {
			int depositerBalance=theCustomer.getAccount().getCurrentBalance()-currentBal;
			int bal=currentBal+acc.getCurrentBalance();
			theCustomer.getAccount().setCurrentBalance(depositerBalance);
			acc.getCustomer();
			System.out.println(acc.getCustomer());
			acc.setCurrentBalance(bal);
			accountService.updateCustomer(theCustomer);
			System.out.println(acc.getCurrentBalance());
			
			model.addAttribute("msg","Payment successful");
			return "depositBalance";
		}
			
			model.addAttribute("msg","Insufficient balance");
			return "depositBalance";
			}
	
	
	//mapping to fund transfer via upi
	@GetMapping("/customer/transferAmount")
	public String transferAmount(HttpServletRequest req,Model model) {
	
			return "transferAmount";
		
	}
	
	
	@RequestMapping(value = "/customer/transferAccountAmount",  method = {RequestMethod.POST, RequestMethod.GET})
	public String transferAccountAmount(HttpServletRequest req, @ModelAttribute("cust") Customer theCust,Model model) {
		
	
			//Customer theCustomer = customerService.get(user.getCustomerId());
			String custId=req.getParameter("customerId");
			boolean exist=custRepo.existsByCustomerId(custId);
			if(!exist) {
				model.addAttribute("msg","UPI Id doesnot exists");
				return "transferAmount";
			}
			//Customer cust=customerService.checkCustomer(theCust);
			
			else {
				return "transferAccountAmount";
				
			}}
			
		

	@PostMapping("/customer/transferBalance")
	public String transferBalance(HttpServletRequest req, @ModelAttribute("cust") Customer theCust,Model model) {
		User user  =  (User)req.getSession(false).getAttribute("user");
			Customer theCustomer = customerService.get(user.getCustomerId());
			
			String custId=req.getParameter("customerId");
			Customer cust=customerService.get(custId);
			
			int currentBal=Integer.parseInt(req.getParameter("balance"));
			if(theCustomer.getAccount().getCurrentBalance()>=currentBal) {
				int bal=theCustomer.getAccount().getCurrentBalance()-currentBal;
				int balance=cust.getAccount().getCurrentBalance()+currentBal;
				theCustomer.getAccount().setCurrentBalance(bal);
				cust.getAccount().setCurrentBalance(balance);
				accountService.updateCustomer(theCustomer);
				accountService.updateCustomer(cust);
				model.addAttribute("msg","Payment successful");
				return "transferAmount";
			}
			else {
			model.addAttribute("msg","insufficient Balance");
			return "transferAmount";
		}
		}
		
	
	//delete
	@RequestMapping("/payee/delete")
	public String deletePayee(@RequestParam("beneficiaryId") int beneficiaryId) {
	payeeService.deletePayee(beneficiaryId);
	return "depositBalance";
	}
}

