package com.demoerp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	@RequestMapping(value="/showform", method=RequestMethod.GET)
	public String showForm()
	{
		return "showform";
	}
	
	@RequestMapping(value="/processform", method = RequestMethod.POST)
	public String processForm(HttpServletRequest request, Model model)
	{
		String name = request.getParameter("userName");
		name=name.toUpperCase();
		model.addAttribute("name", name);
		return "processform";
	}
}
