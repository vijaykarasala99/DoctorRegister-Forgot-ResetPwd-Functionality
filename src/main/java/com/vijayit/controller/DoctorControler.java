package com.vijayit.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.vijayit.binding.ForgotForm;
import com.vijayit.binding.LoginForm;
import com.vijayit.binding.LoginResponse;
import com.vijayit.binding.ResetPwdForm;
import com.vijayit.entity.DoctorEntity;
import com.vijayit.service.DoctorService;
@CrossOrigin("*")
@RestController
public class DoctorControler {
@Autowired
private DoctorService doctorService;

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginForm form) {
	DoctorEntity user = doctorService.login(form);
    if (user != null) {
		LoginResponse response = new LoginResponse();
		response.setUser(user);
		switch (user.getRole()) {
		case "doctor":
			response.setDashboardUrl("/doctor/dashboard");
			break;
		case "technician":
			response.setDashboardUrl("/technician/dashboard");
			break;
		case "units":
			response.setDashboardUrl("/units/dashboard");
			break;
		default:
			response.setDashboardUrl("/patient/dashboard");
			break;
		}
		return ResponseEntity.ok(response);
	} else {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Not Found.");
	}
} 
@PostMapping("/forgot")
public ResponseEntity<String> forgotPassword(@RequestBody ForgotForm forgotPwdForm) {
    if (doctorService.forgotPwd(forgotPwdForm)) {
        return ResponseEntity.ok("Password reset email sent successfully");
    } else {
        return ResponseEntity.badRequest().body("User with the provided email not found");
    }
}

@PostMapping("/reset")
public ResponseEntity<String> resetPassword(@RequestBody ResetPwdForm resetPwdForm) {
    if (doctorService.resetPwd(resetPwdForm)) {
        return ResponseEntity.ok("Password reset successfully");
    } else {
        return ResponseEntity.badRequest().body("Invalid OTP or email. Please try again");
    }
}

@GetMapping("/get/{docid}")
	public DoctorEntity getById(@PathVariable String  docid) {
		return doctorService.getById(docid);
     }
  
  
@GetMapping("/getall")
public List<DoctorEntity> getAll() {
    return doctorService.getAll();
}

@DeleteMapping("/delete/{docid}")
public String deleteUser(@PathVariable String  docid) {
	return doctorService.deleteUser(docid);
	
}  

	
	@PostMapping(path = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public DoctorEntity saveDoctor(@RequestParam("pic") MultipartFile pic,
                                   @RequestParam String docname,
                                   @RequestParam Long mobile,
                                   @RequestParam String email,
                                   @RequestParam String registerid,
                                   @RequestParam String address,
                                   @RequestParam String gender,
                                   @RequestParam String specialization,
                                   @RequestParam String otherservices,
                                   @RequestParam Integer experience,
                                   @RequestParam String qualification,
                                   @RequestParam String department,
                                   @RequestParam String hod,
                                   @RequestParam String pwd,
                                   @RequestParam String confirmPwd,
                                   @RequestParam boolean declaration,
                                   @RequestParam LocalTime startTime,
                                   @RequestParam LocalTime endTime,
                                   @RequestParam String role) {
        return doctorService.saveDoctor(pic, docname, mobile, email, registerid, address, gender, specialization,
      otherservices, experience, qualification, department, hod, pwd, confirmPwd, declaration, startTime,endTime, role);
    }
	    @PutMapping("/{docid}")
	    public ResponseEntity<DoctorEntity> updateDoctor(
	            @PathVariable String docid,
	            @RequestParam("pic") MultipartFile pic,
	            @RequestParam("docname") String docname,
	            @RequestParam("mobile") Long mobile,
	            @RequestParam("email") String email,
	            @RequestParam("registerid") String registerid,
	            @RequestParam("address") String address,
	            @RequestParam("gender") String gender,
	            @RequestParam("specialization") String specialization,
	            @RequestParam("otherservices") String otherservices,
	            @RequestParam("experience") Integer experience,
	            @RequestParam("qualification") String qualification,
	            @RequestParam("department") String department,
	            @RequestParam("hod") String hod,
	            @RequestParam("pwd") String pwd,
	            @RequestParam("confirmPwd") String confirmPwd,
	            @RequestParam("declaration") boolean declaration,
	            @RequestParam("startTime") LocalTime startTime,
	            @RequestParam("endTime") LocalTime endTime,
	            @RequestParam("role") String role) {

	        DoctorEntity updatedDoctor = doctorService.updateDoctor(
	                docid, pic, docname, mobile, email, registerid, address, gender,
	                specialization, otherservices, experience, qualification, department,
	                hod, pwd, confirmPwd, declaration, startTime, endTime, role);

	        return ResponseEntity.ok(updatedDoctor);
	    }
	}
	

