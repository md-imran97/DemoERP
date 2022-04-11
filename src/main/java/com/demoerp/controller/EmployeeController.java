package com.demoerp.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.database.Database;
import com.entity.Employee;
import com.viewmodel.LoginEntity;

@Controller
//@RequestMapping("/employee")
@SessionAttributes("user")
public class EmployeeController {

	//------------ Login controller methods start -------------------------- 
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(Model model, @SessionAttribute(name="user", required=false) Employee employee)
	{
		if(employee !=null)
		{
			if(employee.getEmployeeType()==0) {return "redirect:/admin-home";}
			if(employee.getEmployeeType()==1) {return "redirect:/developer-home";}
		}
		model.addAttribute("loginEntity", new LoginEntity());
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("loginEntity") LoginEntity loginEntity, Model model) throws ClassNotFoundException, SQLException
	{
		
		Database db=new Database();
		Employee employee=db.getEmployeeDb().getEmployee(loginEntity.getEmail());
		if((employee !=null) && (employee.getEmployeePassword().equals(loginEntity.getPassword())))
		{
			if(employee.getEmployeeType()==0)
			{
				model.addAttribute("user",employee);
				return "redirect:/admin-home";
			}
			if(employee.getEmployeeType()==1)
			{
				model.addAttribute("user",employee);
				return "redirect:/developer-home";
			}
		}
		
		model.addAttribute("error", "email or password is incorrect");
		return "login";
	}
	//------------------------- Login controller methods end --------------------
	
	@RequestMapping(value = "/developer-home")
	public String developerHome(Model model, @SessionAttribute(name="user", required=false) Employee employee)
	{
		if(employee==null || employee.getEmployeeType()==0) {return "redirect:/login";}
		model.addAttribute("userInfo", employee);
		return "employee/developerHome";
	}
	
	@RequestMapping(value = "/admin-home")
	public String employeeHome(Model model, @SessionAttribute(name="user", required=false) Employee employee)
	{
		if(employee==null || employee.getEmployeeType()==1) {return "redirect:/login";}
		model.addAttribute("userInfo", employee);
		return "employee/adminHome";
	}
}
