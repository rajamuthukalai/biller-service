package com.sannu.billerservice.model;

public class CustomError {
	private int code;
	private String message;

	public CustomError(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}