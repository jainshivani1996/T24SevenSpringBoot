package com.niit.waw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.niit.waw.model.Customer;


@Controller
public class MappingController {

	
		//mapping to about page
		@RequestMapping("/customer/about")
		public String showAbout(ModelMap theModel)
		{
	
			return "about";
		}
		
		//mapping to home
		@RequestMapping("/home")
		public String showHome(ModelMap theModel)
		{
		
			return "customerDashboard";
		}
		
		
		//mapping to admin home
		@RequestMapping("/adminHome")
		public String showAdminHome(ModelMap theModel)
		{
			
			return "adminDashboard";
		}
		//mapping to contact page
		@RequestMapping("/customer/contact")
		public String showContact(ModelMap theModel)
		{
		
			return "contact";
		}
		
		//mapping to the index
		@RequestMapping("../")
		public String showFormHome(Model theModel) {
			//User theUser = new User();
			//theModel.addAttribute("user", theUser);
			return "index";
		}
		
		
		//mapping to index page
		@RequestMapping("/")
		public String home()
		{
			return "index";
		}
		
		
}
