package com.examportal.service;

import com.examportal.dto.LoginDto;

public interface LoginService {
	public LoginDto validateUser(LoginDto login);

	public Object getUserByEmailId(String userEmailId);
}
