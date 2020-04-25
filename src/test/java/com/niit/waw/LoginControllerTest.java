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
import org.springframework.web.servlet.ModelAndView;

import com.niit.waw.controller.LoginController;
import com.niit.waw.model.User;
import com.niit.waw.service.AccountService;
import com.niit.waw.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LoginController.class})
public class LoginControllerTest {
	
	@InjectMocks
	LoginController login;
	
	@MockBean
	UserService lservice;
	
	@MockBean
	AccountService aService;
	
	
	@Spy
	Model model;
	
	@Spy
	HttpServletRequest req;
	
	@Spy
	ModelAndView modelView;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void showFormForAdd()
	{
		assertEquals(login.showFormForAdd(model),"login");
	}
	
	@Test
	public void loginCustomerTest()
	{
		User usr = new User();
		modelView = new ModelAndView("login");
		usr.setCustomerId("prati@12");
		when(lservice.isUser(usr.getCustomerId())).thenReturn(true);
		when(lservice.checkUser(usr)).thenReturn(null);
		assertEquals(login.processLogin(req, usr,modelView), modelView);
		
	}
	
}

