package com.niit.waw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.niit.waw.controller.TransactionController;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TransactionController.class })
public class TransactionControllerTest {
	
	@InjectMocks
	TransactionController controller;
	
	@MockBean
	UserService lservice;
	
	@MockBean
	CustomerService cservice;
	
	@MockBean
	AccountService aService;
	
	@MockBean
	TransactionService tService;
	
	@MockBean
	PayeeService payee;
	
	@MockBean
	PayeeRepository payeeRepo;
	
	@MockBean
	AccountRepository acRepo;
	
	@MockBean
	CustomerRepository cRepo;
	
	@Spy
	Model model;
	@Spy
	ModelMap modelMap;
	@Spy
	HttpSession ses;
	@Spy
	HttpServletRequest req;
	@Spy
	ModelAndView modelView;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	/*@Test
	public void addAccountBalanceTest() {
		User usr = new User();
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("usr")).thenReturn(usr);
		
		assertEquals(controller.addAccountBalance(req, model), "addVerify");
		assertEquals(controller.addAccountBalance(req, model), "login");
		
	}*/
	
	/*@Test
	public void verifyAccountTest()
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Account acc = new Account();
		Customer theCust = new Customer();
		modelView = new ModelAndView("addBalance");
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(cservice.get(usr.getCustomerId())).thenReturn(theCust);
		when(aService.verifyAccountDetails(acc)).thenReturn(acc);
		when(controller.verifyAccount(req, theCust, acc)).thenReturn(modelView);
		
		assertEquals(controller.verifyAccount(req, theCust, acc), modelView);
		
	}*/
	
	/*@Test
	public void addAccountBalanceTest1() {
		
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer theCust = new Customer();
		theCust.setAccount(new Account());
		theCust.getAccount().setCurrentBalance(0);
		Account account = new Account();
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("currentBal")).thenReturn("0");
		//when(aService.update(theCust)).thenReturn();
		assertEquals(controller.addAccountBalance(req, theCust, account,modelView),"customerDashboard");
	}*/
	
	@Test
	public void generateMiniStatementTest() {
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer c = new Customer();
		c.setCustomerId("prati@12");
		c.setAccount(new Account());
		c.getAccount().setAccountNo(671310560758L);
		List<Transaction> list = new ArrayList<Transaction>();
		
		when(cservice.get(usr.getCustomerId())).thenReturn(c);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(cservice.findByCustomerId(usr.getCustomerId())).thenReturn(c);
		when(tService.findAllByTransAccountNo(c.getAccount().getAccountNo())).thenReturn(list);		
		
		assertEquals(controller.generateMiniStatement(req, model), "miniStatement");
		
	}
	
	@Test
	public void generateMiniStatementShortTest() {
		User usr = new User();
		Customer c = new Customer();
		c.setCustomerId("prati@12");
		c.setAccount(new Account());
		c.getAccount().setAccountNo(671310560758L);
		List<Transaction> list = new ArrayList<Transaction>();
		
		when(cservice.get(usr.getCustomerId())).thenReturn(c);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(cservice.findByCustomerId(c.getCustomerId())).thenReturn(c);
		when(tService.findAllByAccountNoOrderByTransDateDesc(c.getAccount().getAccountNo())).thenReturn(list);		
		assertEquals(controller.generateMiniStatementShort(req, model), "miniStatementShort");
		
	}
	
	@Test
	public void getPayeeTest() {
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer c = new Customer();
		c.setAccount(new Account());
		c.getAccount().setAccountNo(671310560758L);
		List<Payee> list = new ArrayList<>();
		list.add(new Payee());
		
		when(cservice.get(usr.getCustomerId())).thenReturn(c);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(payee.findAllByPayeeAccountNo(c.getAccount().getAccountNo())).thenReturn(list);
		assertEquals(controller.getPayee(req, model), "getPayeeList");
	}
	
	@Test
	public void depositBalanceTest() {
		User usr = new User();
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		assertEquals(controller.depositBalance(req, model), "depositBalance");
	}
	
	@Test
	public void transferTest() {
		User usr = new User();
		long payeeAccount=0;
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		assertEquals(controller.transfer(payeeAccount, req, model), "depositAccountBalance");
	}
	
	@Test
	public void depositBalanceTest1() {
		User usr = new User();
		usr.setCustomerId("prati@12");
		String accNo = "671310560758";
		Account account = new Account();
		Customer theCust = new Customer();
		String ifsc = "T24S12345";
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("accountNo")).thenReturn(accNo);
		when(req.getParameter("ifscCode")).thenReturn(ifsc);
		when(acRepo.existsByAccountNo(Long.parseLong(accNo))).thenReturn(false);
		assertEquals(controller.depositBalance(req, theCust, account, model), "deposit");
	}

	@Test
	public void depositBalanceTestWhenExists1True() {//line 155
		User usr = new User();
		usr.setCustomerId("prati@12");
		long accNo = 671310560758L;
		Account account = new Account();
		Customer theCust = new Customer();
		String ifsc = "T24S12345";
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("accountNo")).thenReturn("671310560758");
		when(req.getParameter("ifscCode")).thenReturn("T24S12345");
		when(acRepo.existsByAccountNo(accNo)).thenReturn(true);
		when(acRepo.existsByIfscCode(ifsc)).thenReturn(false);
		assertEquals(controller.depositBalance(req, theCust, account, model), "deposit");
	}
	
	@Test
	public void depositAmountTest()
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		long accNo = 671310560758L; 
		Account acc = new Account();
		Customer cust=new Customer();
		cust.setAccount(new Account());
		cust.getAccount().setCurrentBalance(-1);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("ac")).thenReturn("671310560758L");
		when(cservice.get(usr.getCustomerId())).thenReturn(cust);
		
		when(aService.findByCustomerAccountNo(accNo)).thenReturn(acc);
		when(req.getParameter("balance")).thenReturn("0");
		
		//from line 206 ?
	}
	
	@Test
	public void transferamountTest() {
		User usr = new User();
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		assertEquals(controller.transferAmount(req, model), "transferAmount");
		
	}
	
	@Test
	public void transferAccountAmountFalseTest() {
		User usr = new User();
		Customer theCust = new Customer();
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(cRepo.existsByCustomerId("prati@12")).thenReturn(false);
		assertEquals(controller.transferAccountAmount(req, theCust, model), "transferAccountAmount");
	}
	
	@Test
	public void transferAccountAmountTrueTest() {
		User usr = new User();
		Customer theCust = new Customer();
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(cRepo.existsByCustomerId("prati@12")).thenReturn(true);
		assertEquals(controller.transferAccountAmount(req, theCust, model), "transferAccountAmount");
	}
	@Test
	public void transferBalanceTest()
	{
		/*User usr = new User();
		usr.setCustomerId("prati@12");
		Customer cust = new Customer();
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(cservice.get("prati@12")).thenReturn(cust);
		when(req.getParameter("balance")).thenReturn("0");
		//from 281
		assertEquals(controller.transferBalance(req, cust, model), "customerDashboard");*/
		User usr = new User();
		usr.setCustomerId("prati@12");
		long accNo = 671310560758L; 
		Account acc = new Account();
		Customer cust=new Customer();
		cust.setAccount(new Account());
		cust.getAccount().setCurrentBalance(-1);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(cservice.get("prati@12")).thenReturn(cust);
		
		when(aService.findByCustomerAccountNo(accNo)).thenReturn(acc);
		when(req.getParameter("balance")).thenReturn("0");
		assertEquals(controller.transferBalance(req, cust, model), "transferAmount");
	}
}
