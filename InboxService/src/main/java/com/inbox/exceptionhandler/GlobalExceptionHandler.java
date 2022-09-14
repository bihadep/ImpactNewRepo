package com.inbox.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.inbox.dto.ExceptionResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponseDto methodToHandleOtherException(Exception ex)
	{
		return new ExceptionResponseDto(new Date(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
