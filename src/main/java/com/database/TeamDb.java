package com.database;

import java.sql.Connection;

public class TeamDb {

	private Connection connection;
	public TeamDb(Connection connection)
	{
		this.connection=connection;
	}
}
