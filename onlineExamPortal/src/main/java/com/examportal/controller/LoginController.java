package com.examportal.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.examportal.model.User;
import com.examportal.service.LoginService;

@RestController

public class LoginController {

	@Autowired
	public LoginService loginService;
	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping(path = "/loginnn/{userEmailId}")

	public User getUserByEmailId(@PathVariable String userEmailId) {

		return modelMapper.map(loginService.getUserByEmailId(userEmailId), User.class);
	}
}
