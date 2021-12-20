package com.examportal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.examportal.dto.UserDto;
import com.examportal.entities.UserEntity;

public interface UserDAO extends CrudRepository<UserEntity, String> {

	UserDto findByUserEmailId(String userEmailId);

	Object save(UserDto user);

}
