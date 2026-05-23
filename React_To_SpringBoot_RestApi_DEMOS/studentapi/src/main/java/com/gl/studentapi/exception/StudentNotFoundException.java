package com.gl.studentapi.exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends RuntimeException{
	
	public StudentNotFoundException(String message)
	{
		super(message);
	}
}
