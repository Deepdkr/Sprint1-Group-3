package com.examportal.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.constants.ExamPortalConstants;

import com.examportal.dto.UserDto;

import com.examportal.entities.UserEntity;

import com.examportal.repositories.UserDAO;
import com.examportal.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDAO userDAO;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Set<UserDto> getAllUser() {
		Set<UserDto> returnSet = new HashSet<>();
		for (UserEntity user : userDAO.findAll()) {
			UserDto userDto = modelMapper.map(user, UserDto.class);
			returnSet.add(userDto);
		}
		return returnSet;
	}

	@Override
	public UserDto addUser(UserDto user) {

		

		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		UserDto returnValue = modelMapper.map(userDAO.save(userEntity), UserDto.class);

		return returnValue;
	}

	@Override
	public UserDto getUserByEmailId(String userEmailID) {

		return modelMapper.map(userDAO.findByUserEmailId(userEmailID), UserDto.class);
	}

}
