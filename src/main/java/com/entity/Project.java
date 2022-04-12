package com.entity;

public class Project {

	private int projectId;
	private String projectName;
	private String projectClientName;
	private String projectClientEmail;
	private int projectStatus;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectClientName() {
		return projectClientName;
	}
	public void setProjectClientName(String projectClientName) {
		this.projectClientName = projectClientName;
	}
	public String getProjectClientEmail() {
		return projectClientEmail;
	}
	public void setProjectClientEmail(String projectClientEmail) {
		this.projectClientEmail = projectClientEmail;
	}
	public int getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(int projectStatus) {
		this.projectStatus = projectStatus;
	}
	
}
