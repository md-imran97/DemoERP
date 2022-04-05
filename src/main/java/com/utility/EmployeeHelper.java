package com.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.Employee;

public class EmployeeHelper {

	public static Employee rsToEmployee(ResultSet rs) throws SQLException
	{
		Employee employee=new Employee();
		while(rs.next())
		{
			/*
			 * System.out.println("in helper "+rs.getInt("id"));
			 * System.out.println("in helper "+rs.getString("name"));
			 * System.out.println("in helper "+rs.getString("email"));
			 * System.out.println("in helper "+rs.getString("password"));
			 * System.out.println("in helper "+rs.getString("designation"));
			 * System.out.println("in helper "+rs.getInt("employee_type"));
			 * System.out.println("in helper "+rs.getInt("gender"));
			 * System.out.println("in helper "+rs.getInt("team_id"));
			 */
			 
			// employee object build with output data
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setEmail(rs.getString("email"));
			employee.setPassword(rs.getString("password"));
			employee.setDesignation(rs.getString("designation"));
			employee.setEmpType(rs.getInt("employee_type"));
			employee.setTeamId(rs.getInt("team_id"));
			
			if(rs.getInt("gender")==1){employee.setGender("male");}
			else {employee.setGender("female");}	
		}
		return employee;
	}
}
