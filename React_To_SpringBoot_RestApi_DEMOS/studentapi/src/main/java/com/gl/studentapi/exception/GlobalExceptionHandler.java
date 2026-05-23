package com.gl.studentapi.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity <ErrorDetails> handleStudentNotFoundException(StudentNotFoundException studentnfe,WebRequest webRequest)
	{
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),
				studentnfe.getMessage(),
				webRequest.getDescription(false)
		);
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StudentApiException.class)
	public ResponseEntity <ErrorDetails> handleStudentApiException(StudentApiException studentae,WebRequest webRequest)
	{
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),
				studentae.getMessage(),
				webRequest.getDescription(false)
		);
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
}
