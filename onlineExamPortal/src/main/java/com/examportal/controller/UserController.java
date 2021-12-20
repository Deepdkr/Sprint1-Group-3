package com.examportal.controller;

import java.util.HashSet;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.dto.UserDto;
import com.examportal.model.User;
import com.examportal.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping(value = "getAllUsers")
	public Set<User> getAllUser() {
		Set<User> returnValue = new HashSet<>();
		for (UserDto userDto : userService.getAllUser()) {
			User user = modelMapper.map(userDto, User.class);
			returnValue.add(user);
		}

		return returnValue;
	}

	@PostMapping("registration")
	public User addUser(@RequestBody User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);

		return modelMapper.map(userService.addUser(userDto), User.class);

	}

	@GetMapping(path = "/login/{userEmailId}")

	public User getUserByEmailId(@PathVariable String userEmailId) {

		return modelMapper.map(userService.getUserByEmailId(userEmailId), User.class);
	}

}
