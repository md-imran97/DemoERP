package com.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;

public class EmployeeHelper {

	public static List<Employee> rsToEmployee(ResultSet rs) throws SQLException
	{
		List<Employee> empList=new ArrayList<Employee>();
		while(rs.next())
		{
			Employee employee=new Employee();
			
			// employee object build with output data
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setEmail(rs.getString("email"));
			employee.setPassword(rs.getString("password"));
			employee.setDesignation(rs.getString("designation"));
			employee.setEmpType(rs.getInt("employee_type"));
			employee.setTeamId(rs.getInt("team_id"));
			employee.setGender(rs.getInt("gender"));
			
			empList.add(employee);
		}
		return empList;
	}
}
