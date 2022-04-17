package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.Development;
import com.entity.Employee;
import com.utility.DevelopmentUtil;
import com.utility.EmployeeUtil;

public class DevelopmentDb {

	private Connection connection;
	public DevelopmentDb(Connection connection)
	{
		this.connection=connection;
	}
	
	public List<Development> getDevelopmentsByEmployeeId(int id) throws SQLException
	{
		String query="select * from development where employee_id = ? and development_status=?";
		PreparedStatement pst=connection.prepareStatement(query);
		pst.setInt(1, id);
		pst.setInt(2, 1);
		ResultSet rs = pst.executeQuery();
		
		var developments=DevelopmentUtil.rsToDevelopments(rs);
		rs.close();pst.close();
		return developments;
	}
	
	public Development getDevelopmentByDevelopmentId(int id) throws SQLException
	{
		String query="select * from development where development_id = ?";
		PreparedStatement pst=connection.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		
		var development=DevelopmentUtil.rsToDevelopment(rs);
		rs.close();pst.close();
		return development;
	}
}
