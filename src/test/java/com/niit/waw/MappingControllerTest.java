package com.niit.waw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.niit.waw.controller.MappingController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MappingController.class })
public class MappingControllerTest {
	
	@InjectMocks
	MappingController mapping;
	
	@Spy
	ModelMap model;
	
	@Spy
	Model theModel;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void showAboutTest()
	{
		//when(mapping.showAbout(model)).thenReturn("about");
		assertEquals(mapping.showAbout(model),"about");
	}
	
	@Test
	public void showHomeTest()
	{
		assertEquals(mapping.showHome(model), "customerDashboard");
	}
	
	@Test
	public void showAdminHomeTest()
	{
		assertEquals(mapping.showAdminHome(model), "adminDashboard");
	}
	
	@Test
	public void showContactTest()
	{
		assertEquals(mapping.showContact(model), "contact");
	}
	
	@Test
	public void showFormHomeTest()
	{
		assertEquals(mapping.showFormHome(theModel), "index");
	}
	
	@Test
	public void showHomeTest1()
	{
		assertEquals(mapping.home(), "index");
	}
	


}
