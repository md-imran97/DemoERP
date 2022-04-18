package com.demoerp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.database.Database;
import com.entity.Employee;
import com.entity.Project;
import com.entity.Team;



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
	
	@RequestMapping(value = "/project-details")
	public String projectDetails(Model model,@RequestParam("projectId")int projectId,@SessionAttribute(name="user", required=false)Employee employee) throws ClassNotFoundException, SQLException
	{
		if(employee==null || employee.getEmployeeType()!=0) {return "redirect:/login";}
		
		Database db=Database.getDatabase();
		Project project=db.getProjectDb().getProject(projectId);
		var teams=db.getTeamDb().getTeamsByProjectId(projectId);
		model.addAttribute("project", project);
		model.addAttribute("teams", teams);
		
		return "project/projectDetails";
	}
	
	@RequestMapping(value = "project-update", method = RequestMethod.POST)
	public String projectDetails(Model model,@ModelAttribute("project")Project project,@SessionAttribute(name="user", required=false)Employee employee) throws ClassNotFoundException, SQLException
	{
		if(employee==null || employee.getEmployeeType()==1) {return "redirect:/login";}
		
		Database db=Database.getDatabase();
		db.getProjectDb().updateProject(project);
		var teams=db.getTeamDb().getTeamsByProjectId(project.getProjectId());
		
		if(project.getProjectStatus()==0)
		{
			for(Team t:teams)
			{
				db.getTeamDb().updateTeamStatus(t.getTeamId(), project.getProjectStatus());
				db.getDevelopmentDb().updateDevelopmentStatus(t.getTeamId(), project.getProjectStatus());
			}
		}
		model.addAttribute("msg","Info updated");
		
		return "redirect:/project-details?projectId="+project.getProjectId();
	}
}
