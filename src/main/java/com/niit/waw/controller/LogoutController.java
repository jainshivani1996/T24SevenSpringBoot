package com.niit.waw.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LogoutController {
	
	
	//logout mapping
	@GetMapping("/logout")
	 public String logout(HttpServletRequest req) {
	  req.getSession().invalidate();
	  return "index";
	 }
}
