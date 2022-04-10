package com.demoerp.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.database.Database;
import com.entity.Employee;

@Controller
//@RequestMapping("/employee")
public class EmployeeController {

	//------------ Login controller -------------------------- 
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(Model model)
	{
		model.addAttribute("a", "from get");
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) throws ClassNotFoundException, SQLException
	{
		model.addAttribute("a", "from post");
		model.addAttribute("msg", "login successful");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Database db=new Database();
		Employee employee=db.getEmployeeDb().getEmployee(email);
		if((employee !=null) && (employee.getEmployeePassword().equals(password)))
		{
			
			if(employee.getEmployeeType()==0)
			{
				return "employee/admin-home";
			}
			if(employee.getEmployeeType()==1)
			{
				System.out.println("yes");
				model.addAttribute("emp",employee);
				return "redirect:/developer-home";
			}
		}
		
		model.addAttribute("error", "email or password is incorrect");
		return "login";
	}
	//---------------------------------------------------------
	@RequestMapping(value = "/developer-home")
	public String developerHome(Model model,HttpServletRequest r)
	{
		model.addAttribute("p", r.getParameter("emp"));
		return "employee/developerHome";
	}
	//public String employeeHome()
}
