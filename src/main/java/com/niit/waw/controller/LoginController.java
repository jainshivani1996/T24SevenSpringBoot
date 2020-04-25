package com.niit.waw.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.waw.model.User;
import com.niit.waw.service.UserService;

@Controller
//@RequestMapping("/user")
public class LoginController 
{
	@Autowired
	private UserService userService;

	
//showing the login form
	@GetMapping("/user/loginForm")
	public String showFormForAdd(Model theModel) {
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "login";
	}

//login validation
	@RequestMapping(value = "/user/loginUser",  method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView processLogin(HttpServletRequest req, @ModelAttribute User theUser,ModelAndView model) {

		if(userService.isUser(theUser.getCustomerId()))
		{
			User usr = userService.checkUser(theUser);
		if (usr == null) {
			
			model = new ModelAndView("login");
			model.addObject("error", "Invalid Username or Password");
			
		} 
		else
		{
		if(usr.getRole().equalsIgnoreCase("C"))
		{	
			((HttpServletRequest) req).getSession().setAttribute("user", usr);
			req.getSession().setAttribute("user", usr);	
			model = new ModelAndView("customerDashboard");
			model.addObject("usr", usr);

		}
		else if(usr.getRole().equalsIgnoreCase("A"))

		{
			req.getSession().setAttribute("admin", usr);	
			model = new ModelAndView("adminDashboard");
			model.addObject("usr", usr);
		}
		}
		}
		else {
		model = new ModelAndView("login");
		model.addObject("error", "User Not Found");
		}
		return model;
	}
}


