package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.Employee;
import com.utility.EmployeeUtil;

public class EmployeeDb {

	private Connection connection;
	public EmployeeDb(Connection connection)
	{
		this.connection=connection;
	}
	
	public Employee getEmployee(String email) throws SQLException
	{
		String query="select * from employee where employee_email = ?";
		PreparedStatement pst=connection.prepareStatement(query);
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		
		Employee emplyee=EmployeeUtil.rsToEmployee(rs);
		rs.close();pst.close();//connection.close();
		return emplyee;
	}
	
	public Employee getEmployee(int empId) throws SQLException
	{
		String query="select * from employee where employee_id = ?";
		PreparedStatement pst=connection.prepareStatement(query);
		pst.setInt(1, empId);
		ResultSet rs = pst.executeQuery();
		
		Employee emplyee=EmployeeUtil.rsToEmployee(rs);
		rs.close();pst.close();//connection.close();
		return emplyee;
	}
	
	public List<Employee> getAllEmployee() throws SQLException
	{
		String query="select * from employee";
		PreparedStatement pst=connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		var emplyees=EmployeeUtil.rsToEmployees(rs);
		rs.close();pst.close();//connection.close();
		return emplyees;
	}
	
	public void addEmployee(Employee employee) throws SQLException
	{
		String query="INSERT INTO employee"
				+ "(employee_name, employee_email, employee_password, employee_gender, "
				+"employee_designation, employee_type, employee_status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pst=connection.prepareStatement(query);
		
		pst.setString(1, employee.getEmployeeName());
		pst.setString(2, employee.getEmployeeEmail());
		pst.setString(3, employee.getEmployeePassword());
		pst.setInt(4, employee.getEmployeeGender());
		pst.setString(5, employee.getEmployeeDesignation());
		pst.setInt(6, employee.getEmployeeType());
		pst.setInt(7, employee.getEmployeeStatus());
		
		pst.executeUpdate();
		pst.close();
	}
	
	public void updateEmployee(Employee employee) throws SQLException
	{
		String query="UPDATE employee SET employee_name=?, employee_email=?, "
				+ "employee_gender=?, employee_designation=?, employee_type=?, "
				+ "employee_status=? WHERE employee_id=?";
		
		PreparedStatement pst=connection.prepareStatement(query);
		
		pst.setString(1, employee.getEmployeeName());
		pst.setString(2, employee.getEmployeeEmail());
		pst.setInt(3, employee.getEmployeeGender());
		pst.setString(4, employee.getEmployeeDesignation());
		pst.setInt(5, employee.getEmployeeType());
		pst.setInt(6, employee.getEmployeeStatus());
		pst.setInt(7, employee.getEmployeeId());
		
		pst.executeUpdate();
		pst.close();
	}
	
}
