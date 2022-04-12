package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private Connection connection = null;
	private String host="localhost";
    private String port="5432";
    private String db_name="demoerp";
    private String username="postgres";
    private String password="admin";
	
    private EmployeeDb employeeDb;
	private TeamDb teamDb;
	private ProjectDb projectDb;
	private LeaveDb leaveDb;
	private AttendanceDb attendanceDb;
	
	// Singleton design: allow to create only one database object
	private static Database db=null;
	public static Database getDatabase() throws ClassNotFoundException, SQLException
	{
		if(db==null) {db=new Database();System.out.println("singleton");}
		return db;
	}
	
	public Database() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
		
		employeeDb=new EmployeeDb(connection);
		teamDb=new TeamDb(connection);
		projectDb=new ProjectDb(connection);
	}
	

	public EmployeeDb getEmployeeDb() {
		return employeeDb;
	}

	public TeamDb getTeamDb() {
		return teamDb;
	}

	public ProjectDb getProjectDb() {
		return projectDb;
	}

	public LeaveDb getLeaveDb() {
		return leaveDb;
	}

	public AttendanceDb getAttendanceDb() {
		return attendanceDb;
	}
}
