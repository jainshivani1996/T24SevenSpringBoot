package com.niit.waw;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.niit.waw.controller.LogoutController;
import com.niit.waw.service.UserService;

//import com.niit.waw.controller.LogoutController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { LogoutController.class})
public class LogoutControllerTest {
	
	@InjectMocks
	LogoutController login;
	
	@MockBean
	UserService uservice;
		
	@Spy
	Model model;
	
	@Spy
	HttpSession ses;
	
	@Spy
	HttpServletRequest req;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void LogoutControllerTest()
	{
		when(req.getSession()).thenReturn(ses);
		assertEquals(login.logout(req),"index");

	}
	

}
