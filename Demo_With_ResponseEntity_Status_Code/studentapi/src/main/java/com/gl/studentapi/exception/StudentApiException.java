package com.gl.studentapi.exception;

import org.springframework.http.HttpStatus;

public class StudentApiException extends RuntimeException{

	private HttpStatus status;
	private String message;
}
