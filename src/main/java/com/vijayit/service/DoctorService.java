package com.vijayit.service;
import java.time.LocalTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vijayit.binding.ForgotForm;
import com.vijayit.binding.LoginForm;
import com.vijayit.binding.ResetPwdForm;
import com.vijayit.entity.DoctorEntity;

public interface DoctorService {
	
public DoctorEntity saveDoctor(MultipartFile pic,String docname,Long mobile,String email,String registerid,
String address,String gender,String specialization,String otherservices,
Integer experience,String qualification,String department,String hod,
String pwd,String confirmPwd,boolean declaration,LocalTime startTime,LocalTime endTime, String role);

public DoctorEntity login(LoginForm form);

public boolean forgotPwd(ForgotForm form);

public boolean resetPwd(ResetPwdForm form);

public String deleteUser(String docid);

public List<DoctorEntity> getAll();

public DoctorEntity getById(String docid);


public DoctorEntity updateDoctor(String docid,MultipartFile pic,String docname,Long mobile,String email,String registerid,
String address,String gender,String specialization,String otherservices,
Integer experience,String qualification,String department,String hod,
String pwd,String confirmPwd,boolean declaration,LocalTime startTime,LocalTime endTime,String role);

}
