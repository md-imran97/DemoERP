package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.Employee;
import com.utility.EmployeeHelper;

public class EmployeeDb {

	private Connection connection;
	public EmployeeDb(Connection connection)
	{
		this.connection=connection;
	}
	
	// get employee info based on employee id
	public Employee getEmployee(int id) throws SQLException
	{
		String query="select * from employee where id="+id;
		Statement stmt=connection.createStatement();
		ResultSet rs    = stmt.executeQuery(query);
		
		Employee employee=null;
		
		if(rs.isBeforeFirst())
		{
			employee= EmployeeHelper.rsToEmployee(rs);
			System.out.println("rs true");
		}
		
		rs.close();stmt.close();connection.close();
		return employee;
	}
	
}
