package com.niit.waw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.niit.waw.controller.DisplayController;
import com.niit.waw.model.Account;
import com.niit.waw.model.Customer;
import com.niit.waw.model.User;
import com.niit.waw.service.AccountService;
import com.niit.waw.service.CustomerService;
import com.niit.waw.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DisplayController.class })
public class DisplayControllerTest {
	
	@InjectMocks
	DisplayController controller;
		
	@MockBean
	UserService lservice;
	
	@MockBean
	CustomerService cservice;
	
	@MockBean
	AccountService aService;
	
	@Spy
	Model model;
	@Spy
	ModelMap modelMap;
	@Spy
	HttpSession ses;
	@Spy
	HttpServletRequest req;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void viewAccoutDetails() {
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer customer = new Customer();
		customer.setCustomerId("prati@12");
		customer.setAccount(new Account());
		customer.getAccount().setCurrentBalance(0);
		//Customer cust=cservice.findByCustomerId(s);
		//int accountBal=customer.getAccount().getCurrentBalance();
				
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(cservice.get(usr.getCustomerId())).thenReturn(customer);
		when(cservice.findByCustomerId(customer.getCustomerId())).thenReturn(customer);
		//when(customer.getAccount().getCurrentBalance()).thenReturn(accountBal);
		
		assertEquals(controller.showaccountDetails(req, model),"customerDashboard");
		
		verify(cservice, times(1)).findByCustomerId(customer.getCustomerId());
	}
	
	@Test
	public void viewAccountProfileTest() {
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer customer = new Customer();
		customer.setCustomerId("prati@12");
		customer.setAccount(new Account());
		customer.getAccount().setCurrentBalance(0);
		customer.getAccount().setIfscCode("T24S12345");
		customer.getAccount().setBranchName("delhi");
		customer.getAccount().setAccountNo(843427859280L);
		customer.setFirstName("Pratishtha");
		customer.setLastName("Sahu");
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(cservice.get(usr.getCustomerId())).thenReturn(customer);
		when(cservice.findByCustomerId(customer.getCustomerId())).thenReturn(customer);
		
		assertEquals(controller.showaccountProfile(req, model),"profileDisplay");
	}

}
