package com.db.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.db.model.Employee;
import com.db.utils.Utility;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class CustomExceptionControler extends ResponseEntityExceptionHandler{
	
	
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Object> dataNotFoundExceptionHandler(DataNotFoundException ex, WebRequest request,
			HttpServletResponse response) {
		log.error("!!!!!!!!! Exception found Data Not Found : {}", ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		var error = new ExceptionResponse(Utility.USER_ID_NOT_FOUND, details);
		error.setExcepion(ex.getClass().getSimpleName());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MyCustomException.class)
	public ResponseEntity<?> exceptionHandler(Exception ex, WebRequest request,
			HttpServletResponse response) {
		log.error("!!!!!!!!! Exception : {}", ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		var error = new ExceptionResponse("Exception in Code" + ex.getMessage(), details);
		error.setExcepion(ex.getClass().getSimpleName());
		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}
	
	

}
