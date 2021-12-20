package com.examportal.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.dto.LoginDto;

import com.examportal.repositories.LoginDAO;

import com.examportal.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public LoginDto validateUser(LoginDto login) {

		return modelMapper.map(loginDAO.findByUserEmailId(login.getUserEmailId()), LoginDto.class);
	}

	@Override
	public LoginDto getUserByEmailId(String userEmailID) {

		return modelMapper.map(loginDAO.findByUserEmailId(userEmailID), LoginDto.class);
	}

}
