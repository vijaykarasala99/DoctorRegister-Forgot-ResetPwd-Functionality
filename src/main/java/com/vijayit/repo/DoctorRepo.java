package com.vijayit.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayit.entity.DoctorEntity;

public interface DoctorRepo extends JpaRepository<DoctorEntity, String> {

	public DoctorEntity findByEmail(String email);

	public DoctorEntity findByEmailAndPwd(String email, String pwd);

	public Optional<DoctorEntity> findByDocid(String docid);
	
}
