package com.utility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.Database;
import com.entity.Development;
import com.view.model.EmployeeAndTeam;

public class EmployeeTeamData {

	public static List<EmployeeAndTeam> getEmployeeAndTeams(int teamId) throws ClassNotFoundException, SQLException
	{
		Database db=Database.getDatabase();
		var developments=db.getDevelopmentDb().getDevelopmentsByTeamId(teamId);
		List<EmployeeAndTeam> employeeAndTeams=new ArrayList<EmployeeAndTeam>();
		for(Development d:developments)
		{
			var employee=db.getEmployeeDb().getEmployee(d.getEmployeeId());
			EmployeeAndTeam et=new EmployeeAndTeam();
			et.setEmployeeId(employee.getEmployeeId());
			et.setEmployeeName(employee.getEmployeeName());
			et.setTeamRole(d.getEmployeeRole());
			et.setTeamActivity(d.getDevelopmentStatus());
			employeeAndTeams.add(et);
		}
		return employeeAndTeams;
	}
}
