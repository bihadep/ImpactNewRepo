package com.admin.exception;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.admin.model.ExceptionResponse;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@ControllerAdvice
public class GlobalUserExceptionHandler {


	@ExceptionHandler(UserAlreadyExistWithGivenEmail.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.CONFLICT)
	public ExceptionResponse methodToHandleUserAlreadyExistWithGivenEmail(Exception ex)
	{
		log.error(ex.getMessage());
	return new ExceptionResponse(new Date(), ex.getMessage(), HttpStatus.CONFLICT);
	}
	
	
	@ExceptionHandler(UserRecordNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionResponse methodToHandleUserRecordNotFoundException(Exception ex)
	{
		log.error(ex.getMessage());
		return new ExceptionResponse(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(SQLException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse methodToHandleSqlException(Exception ex)
	{
		log.error(ex.getMessage());
		return new ExceptionResponse(new Date(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionResponse methodToHandleUserNotFoundException(Exception ex)
	{
		log.error(ex.getMessage());
		return new ExceptionResponse(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnAuthorizeException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ExceptionResponse methodToHandleUnauthorizeUserException(UnAuthorizeException ex)
	{
		log.error(ex.getMessage());
		return new ExceptionResponse(new Date(), ex.getMessage(), HttpStatus.UNAUTHORIZED);
	}

	
	

}
