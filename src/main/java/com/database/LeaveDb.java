package com.database;

import java.sql.Connection;

public class LeaveDb {

	private Connection connection;
	public LeaveDb(Connection connection)
	{
		this.connection=connection;
	}
}
