package com.niit.waw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.waw.controller.DeleteController;
//import com.niit.waw.controller.DisplayController;
import com.niit.waw.service.AccountService;
import com.niit.waw.service.CustomerService;
import com.niit.waw.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DeleteController.class })
public class DeleteControllerTest {
	@InjectMocks
	DeleteController controller;
	
	@MockBean
	UserService uservice;
	@MockBean
	AccountService accountService;
	@MockBean
	CustomerService cservice;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deleteCustomerTest() {
		
		assertEquals(controller.deleteProduct("prati@12"), "adminDashboard");
	
		verify(uservice,times(1)).deleteUser("prati@12");
	
	}
	

}
