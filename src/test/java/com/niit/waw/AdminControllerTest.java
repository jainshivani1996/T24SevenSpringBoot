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

import com.niit.waw.controller.AdminController;
import com.niit.waw.model.Customer;
import com.niit.waw.service.CustomerService;
//import com.niit.waw.service.AccountService;
import com.niit.waw.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AdminController.class })
public class AdminControllerTest {
	
	@InjectMocks
	AdminController controller;
	
	@MockBean
	UserService uservice;
	
	@MockBean
	CustomerService cservice;
	
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
	public void displayCustomerTest() {
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer());
		
		when(cservice.listAllCustomer()).thenReturn(list);
		assertEquals(controller.viewHomePage(model),"adminDashboard");
	}
	
	/*@Test
	public void displayCustomersSizeZeroTest() {
		List<Customer> list = new ArrayList<>();

		when(cservice.listAll()).thenReturn(list);
		assertEquals(controller.viewHomePage(model),"adminDashboard");

	}*/

	@Test
	public void displayCustonerssFalseTest() {

		

		assertEquals(controller.viewHomePage(model),"adminDashboard");

	}

}
