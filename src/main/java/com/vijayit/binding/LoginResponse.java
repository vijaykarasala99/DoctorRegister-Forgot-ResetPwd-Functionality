package com.vijayit.binding;

import com.vijayit.entity.DoctorEntity;

public class LoginResponse {
	private String dashboardUrl;
	private DoctorEntity user;
	public String getDashboardUrl() {
		return dashboardUrl;
	}
	public void setDashboardUrl(String dashboardUrl) {
		this.dashboardUrl = dashboardUrl;
	}
	public DoctorEntity getUser() {
		return user;
	}
	public void setUser(DoctorEntity user) {
		this.user = user;
	}
	public LoginResponse(String dashboardUrl, DoctorEntity user) {
		super();
		this.dashboardUrl = dashboardUrl;
		this.user = user;
	}
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
