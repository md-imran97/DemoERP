package com.utility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.Database;
import com.entity.Development;
import com.view.model.EmployeeProject;

public class EmployeeProjectData {
	
	public static List<EmployeeProject> getEmployeeAndProjects(int empId) throws ClassNotFoundException, SQLException
	{
		Database db=Database.getDatabase();
		var developments=db.getDevelopmentDb().getDevelopmentsByEmployeeId(empId);
		List<EmployeeProject> employeeProjects=new ArrayList<EmployeeProject>();
		for(Development d:developments)
		{
			EmployeeProject e=new EmployeeProject();
			var team=db.getTeamDb().getTeam(d.getTeamId());
			var project=db.getProjectDb().getProject(team.getProjectId());
			
			e.setProjectId(project.getProjectId());
			e.setProjectName(project.getProjectName());
			e.setProjectStatus(project.getProjectStatus());
			
			e.setTeamId(team.getTeamId());
			e.setTeamName(team.getTeamName());
			e.setTeamRole(d.getEmployeeRole());
			e.setTeamStatus(team.getTeamStatus());
			
			employeeProjects.add(e);
		}
		return employeeProjects;
	}
}
