package com.niit.waw;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

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

import com.niit.waw.controller.CustomerController;
import com.niit.waw.model.Account;
import com.niit.waw.model.Customer;
import com.niit.waw.repository.CustomerRepository;
import com.niit.waw.service.AccountService;
import com.niit.waw.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CustomerController.class})
public class RegisterControllerTest {
	
	@InjectMocks
	CustomerController register;
	
	@MockBean
	CustomerService service;
	
	@MockBean
	AccountService aService;
	
	@MockBean 
	CustomerRepository cRepo;
	
	
	@Spy
	ModelMap modelMap;
	
	@Spy
	Model model;
	
	@Spy
	HttpServletRequest req;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void viewRegisterPageTest()
	{
		//Customer theCust = new Customer();
		assertEquals(register.showFormForAdd(modelMap),"addCustomer");
	}
	
	
	@Test
	public void registerTestWhenIdIsTrue()
	{
		Customer c = new Customer();
		/*c.setCustomerId("prati@12");
		c.setFirstName("Pratishtha");
		c.setLastName("Sahu");
		c.setPassword("123");
		c.setDob("12-12-2010");
		c.setEmail("prati@gmail.com");
		c.setAdharNo("123456789");
		c.setPhoneNo("9936472688");
		c.setStreet("sector34");
		c.setCity("Noida");
		c.setPinCode(123456);
		
		Account a = new Account();
		a.setAccountNo(123456789L);
		a.setAccountType("savings");
		a.setBranchName("Noida");
		a.setCurrentBalance(1000);
		a.setIfscCode("ICIC100100");
		
		c.setAccount(a); 
		
		service.saveCustomer(c);
		 verify(service,times(1)).saveCustomer(c);*/
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(req.getParameter("email")).thenReturn("pratishtha@gmail.com");
		
		// from 57 to 66
		
		when(req.getParameter("accountType")).thenReturn("savings");
		when(req.getParameter("branchName")).thenReturn("delhi");
		
		//line 71
		
		Account ac = new Account();
		ac.setAccountNo(671310560758L);
		ac.setAccountType("savings");
		ac.setBranchName("delhi");
		ac.setIfscCode("T24S12345");
		ac.setCurrentBalance(0);
		ac.setCreditStatus("false");
		ac.setPin(0000);
		ac.setDebitCard(1437426022868309L);
		ac.setCustomer(c);
		when(cRepo.existsByCustomerId("prati@12")).thenReturn(true);
		when(cRepo.existsByPhoneNo("9936472688")).thenReturn(false);
		when(cRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(false);
		assertEquals(register.saveCustomer(req, c, model), "addCustomer");
		
		
	}
	
	@Test
	public void registerTestWhenPhoneIsTrue()
	{
		Customer c = new Customer();
		/*c.setCustomerId("prati@12");
		c.setFirstName("Pratishtha");
		c.setLastName("Sahu");
		c.setPassword("123");
		c.setDob("12-12-2010");
		c.setEmail("prati@gmail.com");
		c.setAdharNo("123456789");
		c.setPhoneNo("9936472688");
		c.setStreet("sector34");
		c.setCity("Noida");
		c.setPinCode(123456);
		
		Account a = new Account();
		a.setAccountNo(123456789L);
		a.setAccountType("savings");
		a.setBranchName("Noida");
		a.setCurrentBalance(1000);
		a.setIfscCode("ICIC100100");
		
		c.setAccount(a); 
		
		service.saveCustomer(c);
		 verify(service,times(1)).saveCustomer(c);*/
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(req.getParameter("email")).thenReturn("pratishtha@gmail.com");
		
		// from 57 to 66
		
		when(req.getParameter("accountType")).thenReturn("savings");
		when(req.getParameter("branchName")).thenReturn("delhi");
		
		//line 71
		
		Account ac = new Account();
		ac.setAccountNo(671310560758L);
		ac.setAccountType("savings");
		ac.setBranchName("delhi");
		ac.setIfscCode("T24S12345");
		ac.setCurrentBalance(0);
		ac.setCreditStatus("false");
		ac.setPin(0000);
		ac.setDebitCard(1437426022868309L);
		ac.setCustomer(c);
		when(cRepo.existsByCustomerId("prati@12")).thenReturn(false);
		when(cRepo.existsByPhoneNo("9936472688")).thenReturn(true);
		when(cRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(false);
		assertEquals(register.saveCustomer(req, c, model), "addCustomer");
		
		
	}
	
	@Test
	public void registerTestWhenEmailIsTrue()
	{
		Customer c = new Customer();
		/*c.setCustomerId("prati@12");
		c.setFirstName("Pratishtha");
		c.setLastName("Sahu");
		c.setPassword("123");
		c.setDob("12-12-2010");
		c.setEmail("prati@gmail.com");
		c.setAdharNo("123456789");
		c.setPhoneNo("9936472688");
		c.setStreet("sector34");
		c.setCity("Noida");
		c.setPinCode(123456);
		
		Account a = new Account();
		a.setAccountNo(123456789L);
		a.setAccountType("savings");
		a.setBranchName("Noida");
		a.setCurrentBalance(1000);
		a.setIfscCode("ICIC100100");
		
		c.setAccount(a); 
		
		service.saveCustomer(c);
		 verify(service,times(1)).saveCustomer(c);*/
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(req.getParameter("email")).thenReturn("pratishtha@gmail.com");
		
		// from 57 to 66
		
		when(req.getParameter("accountType")).thenReturn("savings");
		when(req.getParameter("branchName")).thenReturn("delhi");
		
		//line 71
		
		Account ac = new Account();
		ac.setAccountNo(671310560758L);
		ac.setAccountType("savings");
		ac.setBranchName("delhi");
		ac.setIfscCode("T24S12345");
		ac.setCurrentBalance(0);
		ac.setCreditStatus("false");
		ac.setPin(0000);
		ac.setDebitCard(1437426022868309L);
		ac.setCustomer(c);
		when(cRepo.existsByCustomerId("prati@12")).thenReturn(false);
		when(cRepo.existsByPhoneNo("9936472688")).thenReturn(false);
		when(cRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(true);
		assertEquals(register.saveCustomer(req, c, model), "addCustomer");
		
		
	}
	
	@Test
	public void registerTestWhenIdAndPhoneIsTrue()
	{
		Customer c = new Customer();
		/*c.setCustomerId("prati@12");
		c.setFirstName("Pratishtha");
		c.setLastName("Sahu");
		c.setPassword("123");
		c.setDob("12-12-2010");
		c.setEmail("prati@gmail.com");
		c.setAdharNo("123456789");
		c.setPhoneNo("9936472688");
		c.setStreet("sector34");
		c.setCity("Noida");
		c.setPinCode(123456);
		
		Account a = new Account();
		a.setAccountNo(123456789L);
		a.setAccountType("savings");
		a.setBranchName("Noida");
		a.setCurrentBalance(1000);
		a.setIfscCode("ICIC100100");
		
		c.setAccount(a); 
		
		service.saveCustomer(c);
		 verify(service,times(1)).saveCustomer(c);*/
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(req.getParameter("email")).thenReturn("pratishtha@gmail.com");
		
		// from 57 to 66
		
		when(req.getParameter("accountType")).thenReturn("savings");
		when(req.getParameter("branchName")).thenReturn("delhi");
		
		//line 71
		
		Account ac = new Account();
		ac.setAccountNo(671310560758L);
		ac.setAccountType("savings");
		ac.setBranchName("delhi");
		ac.setIfscCode("T24S12345");
		ac.setCurrentBalance(0);
		ac.setCreditStatus("false");
		ac.setPin(0000);
		ac.setDebitCard(1437426022868309L);
		ac.setCustomer(c);
		when(cRepo.existsByCustomerId("prati@12")).thenReturn(true);
		when(cRepo.existsByPhoneNo("9936472688")).thenReturn(true);
		when(cRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(false);
		assertEquals(register.saveCustomer(req, c, model), "addCustomer");
		
		
	}
	
	@Test
	public void registerTestWhenIdAndEmailIsTrue()
	{
		Customer c = new Customer();
		/*c.setCustomerId("prati@12");
		c.setFirstName("Pratishtha");
		c.setLastName("Sahu");
		c.setPassword("123");
		c.setDob("12-12-2010");
		c.setEmail("prati@gmail.com");
		c.setAdharNo("123456789");
		c.setPhoneNo("9936472688");
		c.setStreet("sector34");
		c.setCity("Noida");
		c.setPinCode(123456);
		
		Account a = new Account();
		a.setAccountNo(123456789L);
		a.setAccountType("savings");
		a.setBranchName("Noida");
		a.setCurrentBalance(1000);
		a.setIfscCode("ICIC100100");
		
		c.setAccount(a); 
		
		service.saveCustomer(c);
		 verify(service,times(1)).saveCustomer(c);*/
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(req.getParameter("email")).thenReturn("pratishtha@gmail.com");
		
		// from 57 to 66
		
		when(req.getParameter("accountType")).thenReturn("savings");
		when(req.getParameter("branchName")).thenReturn("delhi");
		
		//line 71
		
		Account ac = new Account();
		ac.setAccountNo(671310560758L);
		ac.setAccountType("savings");
		ac.setBranchName("delhi");
		ac.setIfscCode("T24S12345");
		ac.setCurrentBalance(0);
		ac.setCreditStatus("false");
		ac.setPin(0000);
		ac.setDebitCard(1437426022868309L);
		ac.setCustomer(c);
		when(cRepo.existsByCustomerId("prati@12")).thenReturn(true);
		when(cRepo.existsByPhoneNo("9936472688")).thenReturn(false);
		when(cRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(true);
		assertEquals(register.saveCustomer(req, c, model), "addCustomer");
		
		
	}
	
	@Test
	public void registerTestWhenPhoneAndEmailIsTrue()
	{
		Customer c = new Customer();
		/*c.setCustomerId("prati@12");
		c.setFirstName("Pratishtha");
		c.setLastName("Sahu");
		c.setPassword("123");
		c.setDob("12-12-2010");
		c.setEmail("prati@gmail.com");
		c.setAdharNo("123456789");
		c.setPhoneNo("9936472688");
		c.setStreet("sector34");
		c.setCity("Noida");
		c.setPinCode(123456);
		
		Account a = new Account();
		a.setAccountNo(123456789L);
		a.setAccountType("savings");
		a.setBranchName("Noida");
		a.setCurrentBalance(1000);
		a.setIfscCode("ICIC100100");
		
		c.setAccount(a); 
		
		service.saveCustomer(c);
		 verify(service,times(1)).saveCustomer(c);*/
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(req.getParameter("email")).thenReturn("pratishtha@gmail.com");
		
		// from 57 to 66
		
		when(req.getParameter("accountType")).thenReturn("savings");
		when(req.getParameter("branchName")).thenReturn("delhi");
		
		//line 71
		
		Account ac = new Account();
		ac.setAccountNo(671310560758L);
		ac.setAccountType("savings");
		ac.setBranchName("delhi");
		ac.setIfscCode("T24S12345");
		ac.setCurrentBalance(0);
		ac.setCreditStatus("false");
		ac.setPin(0000);
		ac.setDebitCard(1437426022868309L);
		ac.setCustomer(c);
		when(cRepo.existsByCustomerId("prati@12")).thenReturn(false);
		when(cRepo.existsByPhoneNo("9936472688")).thenReturn(true);
		when(cRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(true);
		assertEquals(register.saveCustomer(req, c, model), "addCustomer");
		
	}

	@Test
	public void registerTestWhenAllTrue()
	{
		Customer c = new Customer();
		/*c.setCustomerId("prati@12");
		c.setFirstName("Pratishtha");
		c.setLastName("Sahu");
		c.setPassword("123");
		c.setDob("12-12-2010");
		c.setEmail("prati@gmail.com");
		c.setAdharNo("123456789");
		c.setPhoneNo("9936472688");
		c.setStreet("sector34");
		c.setCity("Noida");
		c.setPinCode(123456);
		
		Account a = new Account();
		a.setAccountNo(123456789L);
		a.setAccountType("savings");
		a.setBranchName("Noida");
		a.setCurrentBalance(1000);
		a.setIfscCode("ICIC100100");
		
		c.setAccount(a); 
		
		service.saveCustomer(c);
		 verify(service,times(1)).saveCustomer(c);*/
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(req.getParameter("email")).thenReturn("pratishtha@gmail.com");
		
		// from 57 to 66
		
		when(req.getParameter("accountType")).thenReturn("savings");
		when(req.getParameter("branchName")).thenReturn("delhi");
		
		//line 71
		
		Account ac = new Account();
		ac.setAccountNo(671310560758L);
		ac.setAccountType("savings");
		ac.setBranchName("delhi");
		ac.setIfscCode("T24S12345");
		ac.setCurrentBalance(0);
		ac.setCreditStatus("false");
		ac.setPin(0000);
		ac.setDebitCard(1437426022868309L);
		ac.setCustomer(c);
		when(cRepo.existsByCustomerId("prati@12")).thenReturn(true);
		when(cRepo.existsByPhoneNo("9936472688")).thenReturn(true);
		when(cRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(true);
		assertEquals(register.saveCustomer(req, c, model), "addCustomer");
		
		
	}
	
	@Test
	public void registerTestWhenAllFalse()
	{
		Customer c = new Customer();
		/*c.setCustomerId("prati@12");
		c.setFirstName("Pratishtha");
		c.setLastName("Sahu");
		c.setPassword("123");
		c.setDob("12-12-2010");
		c.setEmail("prati@gmail.com");
		c.setAdharNo("123456789");
		c.setPhoneNo("9936472688");
		c.setStreet("sector34");
		c.setCity("Noida");
		c.setPinCode(123456);
		
		Account a = new Account();
		a.setAccountNo(123456789L);
		a.setAccountType("savings");
		a.setBranchName("Noida");
		a.setCurrentBalance(1000);
		a.setIfscCode("ICIC100100");
		
		c.setAccount(a); 
		
		service.saveCustomer(c);
		 verify(service,times(1)).saveCustomer(c);*/
		when(req.getParameter("customerId")).thenReturn("prati@12");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(req.getParameter("email")).thenReturn("pratishtha@gmail.com");
		
		// from 57 to 66
		
		when(req.getParameter("accountType")).thenReturn("savings");
		when(req.getParameter("branchName")).thenReturn("delhi");
		
		//line 71
		
		Account ac = new Account();
		ac.setAccountNo(671310560758L);
		ac.setAccountType("savings");
		ac.setBranchName("delhi");
		ac.setIfscCode("T24S12345");
		ac.setCurrentBalance(0);
		ac.setCreditStatus("false");
		ac.setPin(0000);
		ac.setDebitCard(1437426022868309L);
		ac.setCustomer(c);
		when(cRepo.existsByCustomerId("prati@12")).thenReturn(false);
		when(cRepo.existsByPhoneNo("9936472688")).thenReturn(false);
		when(cRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(false);
		assertEquals(register.saveCustomer(req, c, model), "index");
		
		
	}
}

