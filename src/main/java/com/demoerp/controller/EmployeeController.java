package com.demoerp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/employee")
public class EmployeeController {

	//------------ Login controller -------------------------- 
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String login(Model model)
	{
		model.addAttribute("a", "from get");
		return "login";
	}
	
	@RequestMapping(value = "/", method=RequestMethod.POST)
	public String login(HttpServletRequest request, Model model)
	{
		model.addAttribute("a", "from post");
		model.addAttribute("msg", "login successful");
		return "login";
	}
	//---------------------------------------------------------
	
	//public String employeeHome()
}
