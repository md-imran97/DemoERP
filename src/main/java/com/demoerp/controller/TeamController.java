package com.demoerp.controller;

import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.database.Database;
import com.entity.Employee;
import com.entity.Team;

@Controller
public class TeamController {

	@RequestMapping(value = "/create-team", method = RequestMethod.GET)
	public String createTeam(Model model, @SessionAttribute(name = "user", required =false)Employee employee) throws ClassNotFoundException, SQLException
	{
		if(employee==null || employee.getEmployeeType()!=0) {return "redirect:/login";}
		Database db=Database.getDatabase();
		var projects=db.getProjectDb().getAllProjects();
		model.addAttribute("projects", projects);
		model.addAttribute("team",  new Team());
		return "team/createTeam";
	}
	
	@RequestMapping(value = "/create-team", method = RequestMethod.POST)
	public String createTeam(Model model, @ModelAttribute("team")Team team) throws ClassNotFoundException, SQLException
	{
		Database db=Database.getDatabase();
		db.getTeamDb().addTeam(team);
		model.addAttribute("msg", "Team added");
		return "team/createTeam";
	}
	
	@RequestMapping(value="/show-teams", method = RequestMethod.GET)
	public String showProjects(Model model,@SessionAttribute(name = "user", required =false)Employee employee) throws ClassNotFoundException, SQLException
	{
		if(employee==null || employee.getEmployeeType()!=0) {return "redirect:/login";}
		Database db=Database.getDatabase();
		var teams=db.getTeamDb().getAllTeams();
		model.addAttribute("teams",teams);
		return "team/showTeams";
	}
}
