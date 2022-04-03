package com.database;

import java.sql.Connection;

public class AttendanceDb {

	private Connection connection;
	public AttendanceDb(Connection connection)
	{
		this.connection=connection;
	}
}
