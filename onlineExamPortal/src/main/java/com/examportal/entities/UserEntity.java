package com.examportal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_Details")
public class UserEntity {

	@Id
	@Column(nullable = false, unique = true, length = 20)
	private String userEmailId;
	private String userPsw;
	private String userName;

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

}
