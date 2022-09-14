package com.pms.exception;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

import com.pms.dto.ExceptionResponseDto;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalUserExceptionHandler {

	@ExceptionHandler(UserAlreadyExistWithGivenEmail.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponseDto methodToHandleUserAlreadyExistWithGivenEmail(Exception ex) {
		log.error(ex.getMessage());
		return new ExceptionResponseDto(new Date(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(SQLException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponseDto methodToHandleSqlException(Exception ex) {
		log.error(ex.getMessage());
		return new ExceptionResponseDto(new Date(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionResponseDto methodToHandleUserNotFoundException(Exception ex) {
		log.error(ex.getMessage());
		return new ExceptionResponseDto(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Unauthorized.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ExceptionResponseDto methodToHandleOtherException(Exception ex) {
		return new ExceptionResponseDto(new Date(), "User is Unauthorized", HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ExceptionResponseDto badCredentialsException(BadCredentialsException ex) {
		log.error(ex.getMessage());
		return new ExceptionResponseDto(new Date(), "Bad credentials", HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(SignatureException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ExceptionResponseDto JwtSignatureException(SignatureException ex) {
		log.error(ex.getMessage());
		return new ExceptionResponseDto(new Date(), "Invalid Token", HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(ExpiredJwtException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ExceptionResponseDto JwtSignatureException(ExpiredJwtException ex) {
		log.error(ex.getMessage());
		return new ExceptionResponseDto(new Date(), "Invalid Token", HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(InvalidJwtToken.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ExceptionResponseDto invalidJwtToken(InvalidJwtToken ex) {
		log.error(ex.getMessage());
		return new ExceptionResponseDto(new Date(), "Invalid Token", HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(InactiveUserException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionResponseDto methodToHandleInacativeUser(InactiveUserException ex) {
		log.error(ex.getMessage());
		return new ExceptionResponseDto(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponseDto OtherException(Exception ex) {
		ex.printStackTrace();
		log.error(ex.getMessage());
		return new ExceptionResponseDto(new Date(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
