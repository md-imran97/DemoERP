package com.demoerp.controller;

import java.sql.SQLException;

import javax.annotation.Generated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.database.Database;
import com.entity.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value = "showinfo")
	public String showInfo(Model model) throws SQLException, ClassNotFoundException
	{
		Database db=new Database();
		Employee employee=db.getEmployeeDb().getEmployee(4001);
		
		model.addAttribute("info", employee);
		
		return "showinfo";
	}
}
