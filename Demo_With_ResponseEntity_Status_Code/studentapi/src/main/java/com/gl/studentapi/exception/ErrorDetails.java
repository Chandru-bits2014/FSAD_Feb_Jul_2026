package com.gl.studentapi.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime localDateTime;
	private String message;
	private String description;
	
	public ErrorDetails() {
		super();
	}

	public ErrorDetails(LocalDateTime localDateTime, String message, String description) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.description = description;
	}
	
	
}
