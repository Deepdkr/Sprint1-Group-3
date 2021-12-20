package com.examportal.Exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not Found") // 404
public class QuestionNotFoundException extends Exception {

	public QuestionNotFoundException(String msg) {
		super();
	}

}
