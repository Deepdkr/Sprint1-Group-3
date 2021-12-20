package com.examportal.dto;

import java.util.Set;

public class UserDto {

	private String userEmailId;
	private String userPsw;
	private String userName;
	private Set<UserDto> usersDto;

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserPsw() {
		return userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<UserDto> getUserDto() {
		return usersDto;
	}

	public void setUserDto(Set<UserDto> userDto) {
		this.usersDto = userDto;
	}
}
