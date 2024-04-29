package com.vijayit.binding;

public class LoginForm {

	private String email;
	private String pwd;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public LoginForm(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}

	public LoginForm() {
		super();
		// TODO Auto-generated constructor stub
	}

}
