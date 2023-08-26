package com.db.exception;

import java.util.List;

import lombok.Data;

@Data
public class ExceptionResponse {
	
	private String excepion;
	private String msg;
	private List<String> details;
	
	public ExceptionResponse(String msg, List<String> details) {
		super();
		this.msg = msg;
		this.details = details;
	}
	
	
}
