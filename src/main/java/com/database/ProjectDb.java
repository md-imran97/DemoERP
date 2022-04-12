package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.Employee;
import com.entity.Project;
//import com.utility.EmployeeUtil;
//import com.utility.ProjectUtil;
import com.utility.*;

public class ProjectDb {

	private Connection connection;
	public ProjectDb(Connection connection)
	{
		this.connection=connection;
	}
	
	public void addProject(Project project) throws SQLException
	{
		String query="INSERT INTO project"
				+ "(project_name, project_client_name, project_client_email, project_status) "
				+ "VALUES (?, ?, ?, ?)";
		
		PreparedStatement pst=connection.prepareStatement(query);
		
		pst.setString(1, project.getProjectName());
		pst.setString(2, project.getProjectClientName());
		pst.setString(3, project.getProjectClientEmail());
		pst.setInt(4, project.getProjectStatus());
		
		pst.executeUpdate();
		pst.close();
	}
	
	public List<Project> getAllProjects() throws SQLException
	{
		String query="select * from project";
		PreparedStatement pst=connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		var projects=ProjectUtil.rsToProjects(rs);
		rs.close();pst.close();
		return projects;
	}
}
