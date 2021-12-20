package com.examportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LoginEntity {
	@Id
	@GeneratedValue
	private String userEmailId;
	private String userPsw;

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

}
