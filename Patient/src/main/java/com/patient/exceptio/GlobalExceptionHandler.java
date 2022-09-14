package com.patient.exceptio;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException foundException,WebRequest webRequest){
		log.error("exception occured  resourceNotFoundException()", foundException.getMessage());
		ResponseMessage message = new ResponseMessage(foundException.getMessage(), webRequest.getDescription(false),new Date().toString());
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalException(Exception ex,WebRequest webRequest)
	{
		ex.printStackTrace();
		log.error("exception occured globalException()", ex.getMessage());
		ResponseMessage message = new ResponseMessage(ex.getMessage(), webRequest.getDescription(false), new Date().toString());
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
