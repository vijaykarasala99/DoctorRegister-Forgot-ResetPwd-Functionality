package com.vijayit.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OtpUtil {

	public String generatePwd() {
		Random random = new Random();
		int pwd = 100000 + random.nextInt(900000);
		return "HMS" + pwd;
	}

	public String generateOTP() {
		Random random = new Random();
		int otp = 1000 + random.nextInt(9000);
		return "HMS" + otp;
	}

	public boolean verify(String generatedOTP, String enteredOTP) {
		return generatedOTP.equals(enteredOTP);
	}
	
}
