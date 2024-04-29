package com.vijayit.service;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vijayit.binding.ForgotForm;
import com.vijayit.binding.LoginForm;
import com.vijayit.binding.ResetPwdForm;
import com.vijayit.entity.DoctorEntity;
import com.vijayit.repo.DoctorRepo;
import com.vijayit.util.EmailUtil;
import com.vijayit.util.IdGenerator;
import com.vijayit.util.OtpUtil;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;
@Service
public class DoctorServiceImpl implements DoctorService {
@Autowired
private DoctorRepo doctorRepo;
@Autowired
private EmailUtil emailUtil;
@Autowired
private OtpUtil otpUtil;
@Autowired
private HttpSession session;
@Autowired
private IdGenerator idGenerator;

	@Override
	public DoctorEntity saveDoctor(MultipartFile pic, String docname, Long mobile, String email, String registerid,
			String address, String gender, String specialization, String otherservices, Integer experience,
			String qualification, String department, String hod, String pwd, String confirmPwd, boolean declaration,
			LocalTime startTime, LocalTime endTime, String role) {
		
		String uniqueId = idGenerator.generateUniqueId(role);
		DoctorEntity entity = new DoctorEntity();
		entity.setDocid(uniqueId);
		
		 try {
				entity.setPic(Base64.getEncoder().encodeToString(pic.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		   entity.setDocname(docname);
		   entity.setMobile(mobile);
		   entity.setEmail(email);
		   entity.setRegisterid(registerid);
		   entity.setAddress(address);
		   entity.setGender(gender);
		   entity.setSpecialization(specialization);
		   entity.setOtherservices(otherservices);
		   entity.setExperience(experience);
		   entity.setQualification(qualification);
		   entity.setDepartment(department);
		   entity.setHod(hod);
		   entity.setPwd(pwd);
		   entity.setConfirmPwd(confirmPwd);
		   entity.setDeclaration(declaration);
		   entity.setStartTime(startTime);
		   entity.setEndTime(endTime);
		   entity.setRole(role);
		return doctorRepo.save(entity);
	}
	@Override
	public DoctorEntity login(LoginForm form) {
		return doctorRepo.findByEmailAndPwd(form.getEmail(),form.getPwd());
	}

	
	@Override
	public boolean forgotPwd(ForgotForm form) {
		DoctorEntity doctor= doctorRepo.findByEmail(form.getEmail());
	      if(doctor==null) {
		     return false;
		     }
	      
	      String otp = otpUtil.generateOTP();
	      session.setAttribute("resetOtp", otp);
	      session.setAttribute("forgotpwdEmail", form.getEmail());
	      String subject = "Recover Password With OTP";
	      String message = "Please Don't Share This OTP... This Is Confidential !! : " + otp;
	      emailUtil.sendEmail(form.getEmail(), subject, message);
	      return true;
	}
	@Override
	public boolean resetPwd(ResetPwdForm form) {
		  String email = (String) session.getAttribute("forgotpwdEmail"); 
		    String sessionOtp = (String) session.getAttribute("resetOtp");
		    String otp = form.getOtp();
		    String newPwd = form.getNewPwd();
		    String confirmPwd = form.getConfirmPwd();

		    if (!otp.equals(sessionOtp)) {
		        return false;
		    }

		    if (!newPwd.equals(confirmPwd)) {
		        return false;
		    }

		    DoctorEntity doctor = doctorRepo.findByEmail(email);
		    if (doctor == null) {
		        return false;
		    }
		    doctor.setPwd(newPwd);
		    doctorRepo.save(doctor);
		    session.invalidate();
		    return true;
		}
	
	

	@Override
	public DoctorEntity updateDoctor(String docid, MultipartFile pic, String docname, Long mobile, String email,
			String registerid, String address, String gender, String specialization, String otherservices,
			Integer experience, String qualification, String department, String hod, String pwd, String confirmPwd,
			boolean declaration, LocalTime startTime, LocalTime endTime, String role) {
		  
Optional<DoctorEntity> optionalDoctor = doctorRepo.findByDocid(docid);
DoctorEntity doctorEntity = optionalDoctor.orElseThrow(() -> new EntityNotFoundException("Doctor with id " + docid + " not found"));

		  try {
			  doctorEntity.setPic(Base64.getEncoder().encodeToString(pic.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
	        doctorEntity.setDocname(docname);
	        doctorEntity.setMobile(mobile);
	        doctorEntity.setEmail(email);
	        doctorEntity.setRegisterid(registerid);
	        doctorEntity.setAddress(address);
	        doctorEntity.setGender(gender);
	        doctorEntity.setSpecialization(specialization);
	        doctorEntity.setOtherservices(otherservices);
	        doctorEntity.setExperience(experience);
	        doctorEntity.setQualification(qualification);
	        doctorEntity.setDepartment(department);
	        doctorEntity.setHod(hod);
	        doctorEntity.setDeclaration(declaration);
	        doctorEntity.setStartTime(startTime);
	        doctorEntity.setEndTime(endTime);
	        doctorEntity.setRole(role);
	        return doctorRepo.save(doctorEntity);
	    }
	@Override
	public String deleteUser(String docid) {
   Optional<DoctorEntity> user=doctorRepo.findByDocid(docid);
   if(user.isPresent()) {
	  doctorRepo.deleteById(docid);
	  return "Doctor Deleted";
  }else {
return "No Doctor Found";
}}
	
	@Override
	public DoctorEntity getById(String docid) {
		Optional<DoctorEntity> findById = doctorRepo.findByDocid(docid);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	@Override
	public List<DoctorEntity> getAll() {
		return doctorRepo.findAll();
	}
}