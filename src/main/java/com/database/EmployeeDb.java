package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.entity.Employee;
import com.utility.EmployeeHelper;

public class EmployeeDb {

	private Connection connection;
	public EmployeeDb(Connection connection)
	{
		this.connection=connection;
	}
	
	// get employee info based on employee id
	public List<Employee> getEmployee(String email) throws SQLException
	{
		String query="select * from employee where email = ?";
		PreparedStatement pst=connection.prepareStatement(query);
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		
		List<Employee> empList;
		empList= EmployeeHelper.rsToEmployee(rs);
		rs.close();pst.close();connection.close();
		return empList;
	}
	
	// save employee info form to database
	public void setEmployee(Employee emp) throws SQLException
	{
		String query="INSERT INTO employee"
				+ "(name, email, password, gender, designation, employee_type, team_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pst=connection.prepareStatement(query);
		
		pst.setString(1, emp.getName());
		pst.setString(2, emp.getEmail());
		pst.setString(3, emp.getPassword());
		pst.setInt(4, emp.getGender());
		pst.setString(5, emp.getDesignation());
		pst.setInt(6, emp.getEmpType());
		pst.setInt(7, emp.getTeamId());
		
		pst.executeUpdate();
	}
	
}
