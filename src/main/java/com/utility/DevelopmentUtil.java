package com.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Development;
import com.entity.Employee;

public class DevelopmentUtil {

	public static Development rsToDevelopment(ResultSet rs) throws SQLException
	{
		Development development=null;
		while(rs.next())
		{
			development=new Development();
			
			// Development object build from result set data
			development.setDevelopmentId(rs.getInt("development_id"));
			development.setTeamId(rs.getInt("team_id"));
			development.setEmployeeId(rs.getInt("employee_id"));
			development.setEmployeeRole(rs.getInt("employee_role"));
			development.setDevelopmentStatus(rs.getInt("development_status"));
		}
		return development;
	}
	
	public static List<Development> rsToDevelopments(ResultSet rs) throws SQLException
	{
		List<Development> developments=new ArrayList<Development>();
		while(rs.next())
		{
			Development d=new Development();
			
			// Development object build from result set data
			d.setDevelopmentId(rs.getInt("development_id"));
			d.setTeamId(rs.getInt("team_id"));
			d.setEmployeeId(rs.getInt("employee_id"));
			d.setEmployeeRole(rs.getInt("employee_role"));
			d.setDevelopmentStatus(rs.getInt("development_status"));
			developments.add(d);
		}
		return developments;
	}
}
