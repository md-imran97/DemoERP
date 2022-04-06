package com.demoerp.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.database.Database;
import com.entity.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/showinfo")
	public String showInfo(Model model) throws SQLException, ClassNotFoundException
	{
		Database db=new Database();
		List<Employee> empList=db.getEmployeeDb().getEmployee("im@g.com");
		System.out.println("list size:"+empList.size());
		if(empList.size()==0) {model.addAttribute("info", null);}
		else {model.addAttribute("info", empList.get(0));}
		
		
		return "showinfo";
	}
	
	@RequestMapping(value="/viewform")
	public String showForm(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "showform";
	}
	
	@RequestMapping(value="/submitform", method = RequestMethod.POST)
	public String showForm(@ModelAttribute("employee") Employee employee, Model model) throws ClassNotFoundException, SQLException
	{
		Database db=new Database();
		if(db.getEmployeeDb().getEmployee(employee.getEmail()).size()>0)
		{
			model.addAttribute("errEmail", "email already exist");
			return "showform";
		}
		db=new Database();
		System.out.println(employee.getDesignation());
		db.getEmployeeDb().setEmployee(employee);
		model.addAttribute("info", "form saved to database");
		return "showform";
	}
	
}
