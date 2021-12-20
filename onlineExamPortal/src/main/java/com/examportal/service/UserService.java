package com.examportal.service;

import java.util.Set;

import com.examportal.dto.UserDto;

public interface UserService {

	public UserDto addUser(UserDto user);

	public Set<UserDto> getAllUser();

	public UserDto getUserByEmailId(String userEmailId);

}
