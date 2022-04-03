package com.database;

import java.sql.Connection;

public class ProjectDb {

	private Connection connection;
	public ProjectDb(Connection connection)
	{
		this.connection=connection;
	}
}
