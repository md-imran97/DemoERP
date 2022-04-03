package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDb {

	private Connection connection;
	public EmployeeDb(Connection connection)
	{
		this.connection=connection;
	}
	
}
