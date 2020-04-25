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
import com.niit.waw.controller.UpdationController;
import com.niit.waw.model.Account;
import com.niit.waw.model.Customer;
import com.niit.waw.model.User;
import com.niit.waw.repository.AccountRepository;
import com.niit.waw.repository.CustomerRepository;
import com.niit.waw.service.AccountService;
import com.niit.waw.service.CustomerService;
import com.niit.waw.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DisplayController.class })
public class UpdateControllerTest {
	
	
	
	@InjectMocks
	UpdationController update;
		
	@MockBean
	UserService lservice;
	
	@MockBean
	CustomerService cservice;
	
	@MockBean
	AccountService aService;
	
	@MockBean
	CustomerRepository customerRepo;
	
	@MockBean
	AccountRepository arepo;
	
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
	public void updateEmailTest() {
		User usr = new User();
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		assertEquals(update.updateEmail(req, model),"updateCustomerEmail");
	}
	
	@Test
	public void updateEmailFalse1Test() {
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(null);
	
	}
	
	@Test
	public void updateEmailTest1() {//line 66
		User usr = new User();
		Customer theCust = new Customer();
		usr.setCustomerId("prati@12");
		
		when(cservice.get(usr.getCustomerId())).thenReturn(theCust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("email")).thenReturn("pratishtha@gmail.com");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		//assertEquals(update.updateEmail(req, theCust, model), "customerDashboard");
		
	}
	
	@Test
	public void updateEmailWhenEmptyTest() {//line 71
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer theCust = new Customer();
		
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(cservice.get(usr.getCustomerId())).thenReturn(theCust);
		when(req.getParameter("email")).thenReturn("");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		
		when(customerRepo.existsByPhoneNo("9936472688")).thenReturn(true);
		assertEquals(update.updateEmail(req, theCust, model), "updateCustomerEmail");
	}
	
	@Test
	public void updateEmailFalseTest() {//line 78
		User usr = new User();
		Customer theCust = new Customer();
		theCust.setPhoneNo("9936472688");
	
		
		when(cservice.get(usr.getCustomerId())).thenReturn(theCust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("email")).thenReturn("");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		
		//when(customerRepo.existsByPhoneNo("phoneNo")).thenReturn(true);
		//when(aService.update(theCust)).thenReturn(" ");
		when(customerRepo.existsByPhoneNo("phoneNo")).thenReturn(false);
		theCust.setPhoneNo("9936472688");
		assertEquals(update.updateEmail(req, theCust, model), "updateCustomerEmail");
		verify(aService,times(1)).updateCustomer(theCust);
	}
	@Test
	public void updateEmailFalse2Test() {
		User usr = new User();
		Customer theCust = new Customer();
		theCust.setPhoneNo("9936472688");
		
		
		when(cservice.get(usr.getCustomerId())).thenReturn(theCust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("email")).thenReturn("");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		
		//when(customerRepo.existsByPhoneNo("phoneNo")).thenReturn(true);
		//when(aService.update(theCust)).thenReturn(" ");
		when(customerRepo.existsByPhoneNo("phoneNo")).thenReturn(true);
		assertEquals(update.updateEmail(req, theCust, model), "updateCustomerEmail");
		
	}
	
	@Test
	public void updateEmailWhenEmailIsNotNullTest()
	{
		User usr = new User();
		Customer thecust = new Customer();
		//thecust.setEmail("pratishtha@gmail.com");
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("email")).thenReturn("pratishtha@gmail.com");
		when(req.getParameter("phoneNo")).thenReturn("");
		when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(true);
		assertEquals(update.updateEmail(req, thecust, model), "updateCustomerEmail");
		
	}
	
	@Test
	public void updateEmailWhenEmailIsNotNullFalseTest()//line91 to 97
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer thecust = new Customer();
		//thecust.setEmail("pratishtha@gmail.com");
		
		when(cservice.get(usr.getCustomerId())).thenReturn(new Customer());
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("email")).thenReturn("");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(false);
		thecust.setEmail("pratishtha@gmail.com");
		assertEquals(update.updateEmail(req, thecust, model), "updateCustomerEmail");
		verify(aService,times(1)).updateCustomer(thecust);
		
	}
	
	@Test
	public void updateEmailWhenEmailIsNotNullAndPhoneNotNullTest1()//line98 to 104
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer thecust = new Customer();
		//thecust.setEmail("pratishtha@gmail.com");
		
		when(cservice.get(usr.getCustomerId())).thenReturn(new Customer());
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("email")).thenReturn("");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(customerRepo.existsByPhoneNo("9936472688")).thenReturn(true);
		//when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(true);
		when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(true);
		//thecust.setEmail("pratishtha@gmail.com");
		assertEquals(update.updateEmail(req, thecust, model), "updateCustomerEmail");
		//verify(aService,times(1)).update(thecust);
		
	}

	@Test
	public void updateEmailWhenEmailIsNotNullAndPhoneNotNullTest2()//line106 to 108
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer thecust = new Customer();
		//thecust.setEmail("pratishtha@gmail.com");
		
		when(cservice.get(usr.getCustomerId())).thenReturn(new Customer());
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("email")).thenReturn("");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(customerRepo.existsByPhoneNo("9936472688")).thenReturn(true);
		//when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(true);
		//when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(false);
		//thecust.setEmail("pratishtha@gmail.com");
		//thecust.setPhoneNo("9936472688");
		assertEquals(update.updateEmail(req, thecust, model), "updateCustomerEmail");
		//verify(aService,times(1)).update(thecust);
		
	}
	
	@Test
	public void updateEmailWhenEmailIsNotNullAndPhoneNotNullTest3()//line110 to 112
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer thecust = new Customer();
		//thecust.setEmail("pratishtha@gmail.com");
		
		when(cservice.get(usr.getCustomerId())).thenReturn(new Customer());
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("email")).thenReturn("");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(customerRepo.existsByPhoneNo("9936472688")).thenReturn(true);
		when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(true);
		//when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(false);
		//thecust.setEmail("pratishtha@gmail.com");
		//thecust.setPhoneNo("9936472688");
		assertEquals(update.updateEmail(req, thecust, model), "updateCustomerEmail");
		//verify(aService,times(1)).update(thecust);
		
	}
	
	@Test
	public void updateEmailWhenEmailIsNotNullAndPhoneNotNullTest4()//line115 to 120
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer thecust = new Customer();
		//thecust.setEmail("pratishtha@gmail.com");
		
		when(cservice.get(usr.getCustomerId())).thenReturn(new Customer());
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("email")).thenReturn("");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(customerRepo.existsByPhoneNo("9936472688")).thenReturn(false);
		when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(false);
		//when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(false);
		thecust.setEmail("pratishtha@gmail.com");
		thecust.setPhoneNo("9936472688");
		assertEquals(update.updateEmail(req, thecust, model), "updateCustomerEmail");
		verify(aService,times(1)).updateCustomer(thecust);
		
	}

	
	@Test
	public void updateEmailWhenEmailIsNotNullAndPhoneNotNullTest()//line93 to 99
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer thecust = new Customer();
		//thecust.setEmail("pratishtha@gmail.com");
		
		when(cservice.get(usr.getCustomerId())).thenReturn(new Customer());
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("email")).thenReturn("");
		when(req.getParameter("phoneNo")).thenReturn("9936472688");
		when(customerRepo.existsByPhoneNo("9936472688")).thenReturn(false);
		when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(true);
		//when(customerRepo.existsByEmail("pratishtha@gmail.com")).thenReturn(false);
		//thecust.setEmail("pratishtha@gmail.com");
		assertEquals(update.updateEmail(req, thecust, model), "customerDashboard");
		//verify(aService,times(1)).update(thecust);
		
	}
	
	@Test
	public void updatePasswordTest() {
		User usr = new User();
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		
		assertEquals(update.updatePassword(req, model), "updateCustomerPassword");
	}
	
	@Test
	public void updatePasswordFalseTest() {
		
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(null);
		
	
	}
	
	@Test
	public void updatePasswordTest1() {//line 149
		User usr = new User();
		usr.setCustomerId("prati@12");
		usr.setPassword("Pass@271");
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("password")).thenReturn("Pass@271");
		when(req.getParameter("confirmPassword")).thenReturn("Pass@272");
		assertEquals(update.updatePassword(req, usr, model), "updateCustomerPassword");
	}
	
	@Test
	public void updatePasswordFalseTest1() {
		
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(null);
		
		assertEquals(update.updatePassword(req, model), "login");
	}
	
	@Test
	public void generatePinTest() {
		User usr = new User();
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		assertEquals(update.generatePin(req, model), "generatePin");
	}
	
	@Test
	public void generatePinFalseTest() {
	
		
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(null);
		
	}
	
	@Test
	public void generatePinformTest() {
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer cust = new Customer();
		cust.setCustomerId("prati@12");
		
		when(cservice.get(usr.getCustomerId())).thenReturn(cust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("accountNo")).thenReturn("671310560758");
		when(req.getParameter("debitCard")).thenReturn("1437426022868309");
		when(req.getParameter("cvv")).thenReturn("900");
		when(req.getParameter("confirmPin")).thenReturn("1234");
		//when(cust.getAccount().getAccountNo())).thenReturn(accountNo);
		//line 205 to 209
		
		assertEquals(update.generatePinForm(req, model), "generatePin");
		verify(aService,times(1)).updateCustomer(cust);
	}
	
	@Test
	public void generatePinformFalseTest() {
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer cust = new Customer();
		cust.setCustomerId("prati@12");
		
		when(cservice.get(usr.getCustomerId())).thenReturn(cust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(null);
		when(req.getParameter("accountNo")).thenReturn("671310560758");
		when(req.getParameter("debitCard")).thenReturn("1437426022868309");
		when(req.getParameter("cvv")).thenReturn("900");
		when(req.getParameter("confirmPin")).thenReturn("1234");
		
		
				//line 205 to 209
		
		assertEquals(update.generatePinForm(req, model), "generatePin");
		//verify(aService,times(1)).update(cust);
	}
	
	@Test
	public void applyNowTest()
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer cust = new Customer();
		
		when(cservice.get(usr.getCustomerId())).thenReturn(cust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		assertEquals(update.applyNow(req, model), "applyNow");
		
	}
	
	@Test
	public void applyNowFalseTest()
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer cust = new Customer();
		
		when(cservice.get(usr.getCustomerId())).thenReturn(cust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(null);
		assertEquals(update.applyNow(req, model), "applyNow");
		
	}
	
	@Test
	public void addBalanceTest()
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer cust = new Customer();
		
		when(cservice.get(usr.getCustomerId())).thenReturn(cust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		assertEquals(update.addBalance(req, model), "addBalance");
	}
	
	@Test
	public void addBalanceFalseTest()
	{
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer cust = new Customer();
		
		when(cservice.get(usr.getCustomerId())).thenReturn(cust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(null);
		assertEquals(update.addBalance(req, model), "login");
	}
	
	@Test
	public void addAccountBalanceTest() {
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer cust = new Customer();
		cust.setCustomerId("prati@12");
		Account acc = new Account();
		acc.setAccountNo(671310560758L);
		acc.setCurrentBalance(0);
		acc.setCvv(900);
		acc.setPin(1234);
		
		when(cservice.get(usr.getCustomerId())).thenReturn(cust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("debitCard")).thenReturn("1437426022868309");
		when(req.getParameter("cvv")).thenReturn("900");
		when(req.getParameter("pin")).thenReturn("1234");
		when(arepo.existsByDebitCard(1437426022868309L)).thenReturn(true);
		when(arepo.findByDebitCard(1437426022868309L)).thenReturn(acc);
		assertEquals(update.addAccountBalance(req, model), "addBalance");
	}

	@Test
	public void addAccountBalanceFalseTest() {
		User usr = new User();
		usr.setCustomerId("prati@12");
		Customer cust = new Customer();
		cust.setCustomerId("prati@12");
		Account acc = new Account();
		acc.setAccountNo(671310560758L);
		acc.setCurrentBalance(0);
		acc.setCvv(900);
		acc.setPin(1234);
		
		when(cservice.get(usr.getCustomerId())).thenReturn(cust);
		when(req.getSession(false)).thenReturn(ses);
		when(req.getSession(false).getAttribute("user")).thenReturn(usr);
		when(req.getParameter("debitCard")).thenReturn("1437426022868309");
		when(req.getParameter("cvv")).thenReturn("900");
		when(req.getParameter("pin")).thenReturn("1234");
		when(arepo.existsByDebitCard(1437426022868309L)).thenReturn(false);
		when(arepo.findByDebitCard(1437426022868309L)).thenReturn(acc);
		assertEquals(update.addAccountBalance(req, model), "addBalance");
	}
}
