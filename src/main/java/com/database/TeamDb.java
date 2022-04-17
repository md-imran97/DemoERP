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
	
	public Team getTeam(int teamId) throws SQLException
	{
		String query="select * from team where team_id="+teamId;
		PreparedStatement pst=connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		var team=TeamUtil.rsToTeam(rs);
		rs.close();pst.close();
		return team;
	}
	
	public Team getTeamByProjectId(int projectId) throws SQLException
	{
		String query="select * from team where project_id="+projectId;
		PreparedStatement pst=connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		var team=TeamUtil.rsToTeam(rs);
		rs.close();pst.close();
		return team;
	}
	
	public void updateTeam(Team team) throws SQLException
	{
		String query="UPDATE team SET team_name=?, team_status=?, project_id=? "
				+ "WHERE team_id=?";
		
		PreparedStatement pst=connection.prepareStatement(query);
		
		pst.setString(1, team.getTeamName());
		pst.setInt(2, team.getTeamStatus());
		pst.setInt(3, team.getProjectId());
		pst.setInt(4, team.getTeamId());
		
		pst.executeUpdate();
		pst.close();
	}
}
