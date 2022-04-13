package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.Team;
import com.utility.TeamUtil;

public class TeamDb {

	private Connection connection;
	public TeamDb(Connection connection)
	{
		this.connection=connection;
	}
	
	public void addTeam(Team team) throws SQLException
	{
		String query="INSERT INTO team"
				+ "(team_name, team_status, project_id)"
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement pst=connection.prepareStatement(query);
		
		pst.setString(1, team.getTeamName());
		pst.setInt(2, team.getTeamStatus());
		pst.setInt(3, team.getProjectId());
		
		pst.executeUpdate();
		pst.close();
	}
	
	public List<Team> getAllTeams() throws SQLException
	{
		String query="select * from team";
		PreparedStatement pst=connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		var teams=TeamUtil.rsToTeams(rs);
		rs.close();pst.close();
		return teams;
	}
}
