package com.vijayit.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class DoctorEntity {
	@Id
	private String docid;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String pic;
	private String docname;
	private Long mobile;
	private String email;
	private String registerid;
	private String address;
	private String gender;
	private String specialization;
	private String otherservices;
	private Integer experience;
	private String qualification;
	private String department;
	private String hod;
	private String pwd;
	private String confirmPwd;
	private boolean declaration;
	private LocalTime startTime;
	private LocalTime endTime;
	private String role;

	
	
	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterid() {
		return registerid;
	}

	public void setRegisterid(String registerid) {
		this.registerid = registerid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getOtherservices() {
		return otherservices;
	}

	public void setOtherservices(String otherservices) {
		this.otherservices = otherservices;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public boolean isDeclaration() {
		return declaration;
	}

	public void setDeclaration(boolean declaration) {
		this.declaration = declaration;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public DoctorEntity(String docid, String pic, String docname, Long mobile, String email, String registerid,
			String address, String gender, String specialization, String otherservices, Integer experience,
			String qualification, String department, String hod, String pwd, String confirmPwd, boolean declaration,
			LocalTime startTime, LocalTime endTime, String role) {
		super();
		this.docid = docid;
		this.pic = pic;
		this.docname = docname;
		this.mobile = mobile;
		this.email = email;
		this.registerid = registerid;
		this.address = address;
		this.gender = gender;
		this.specialization = specialization;
		this.otherservices = otherservices;
		this.experience = experience;
		this.qualification = qualification;
		this.department = department;
		this.hod = hod;
		this.pwd = pwd;
		this.confirmPwd = confirmPwd;
		this.declaration = declaration;
		this.startTime = startTime;
		this.endTime = endTime;
		this.role = role;
	}
	public DoctorEntity() {
		super();
		
	}

}