package com.vijayit.binding;


public class ResetPwdForm {

	private String otp;
	private String newPwd;
	private String confirmPwd;

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public ResetPwdForm(String otp, String newPwd, String confirmPwd) {
		super();
		this.otp = otp;
		this.newPwd = newPwd;
		this.confirmPwd = confirmPwd;
	}

	public ResetPwdForm() {
		super();
		// TODO Auto-generated constructor stub
	}


}
