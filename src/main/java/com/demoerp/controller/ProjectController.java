package com.demoerp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.database.Database;
import com.entity.Employee;
import com.entity.Project;



@Controller
public class ProjectController {

	@RequestMapping(value = "/create-project", method=RequestMethod.GET)
	public String creatProject(Model model, @SessionAttribute(name="user", required=false)Employee employee)
	{
		if(employee==null || employee.getEmployeeType()!=0) {return "redirect:/login";}
		model.addAttribute("project", new Project());
		return "project/createProject";
	}
	
	@RequestMapping(value = "/create-project", method=RequestMethod.POST)
	public String creatProject(Model model, @ModelAttribute("project") Project project) throws ClassNotFoundException, SQLException
	{
		Database db=Database.getDatabase();
		db.getProjectDb().addProject(project);
		model.addAttribute("msg", "Project added");
		return "project/createProject";
	}
	
	@RequestMapping(value="/show-projects", method=RequestMethod.GET)
	public String showProjects(Model model, @SessionAttribute(name="user", required=false)Employee employee) throws ClassNotFoundException, SQLException
	{
		if(employee==null || employee.getEmployeeType()!=0) {return "redirect:/login";}
		
		Database db=Database.getDatabase();
		List<Project> projects=db.getProjectDb().getAllProjects();
		model.addAttribute("projects", projects);
		
		return "project/showProjects";
	}
}
