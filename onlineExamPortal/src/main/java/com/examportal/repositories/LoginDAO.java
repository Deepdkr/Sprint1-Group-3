package com.examportal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.examportal.entities.LoginEntity;



public interface LoginDAO extends CrudRepository<LoginEntity, String> {
	LoginEntity findByUserEmailId(String userEmailId);
}
