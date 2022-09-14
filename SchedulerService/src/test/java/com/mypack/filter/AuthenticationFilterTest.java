package com.mypack.filter;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.mypack.dto.TokenRequest;
import com.mypack.dto.TokenResponse;
import com.mypack.util.Constant;

@ExtendWith(MockitoExtension.class)
class AuthenticationFilterTest {

	@Mock
	HttpServletRequest request;
	
	@Mock
	RestTemplate restTemplate;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	FilterChain chain;
	
	@InjectMocks
	AuthenticationFilter filter;
	
	@Test
	void testDoFilterInternalHttpServletRequestHttpServletResponseFilterChain() throws IOException, ServletException {
		when(request.getHeader("Authorization")).thenReturn("Bearer eFGSsdfergdfDSFSSDF324SDGDFBDFBd");
		TokenResponse tokenResponse = new TokenResponse(true);
		when(restTemplate.postForObject(Mockito.eq(Constant.USER_SERVICE_BASE_URL + "/authenticate/isValidToken"), 
				Mockito.any(TokenRequest.class),Mockito.eq(TokenResponse.class)))
			.thenReturn(tokenResponse);
		doNothing().when(chain).doFilter(request, response);
		filter.doFilterInternal(request, response, chain);
	}
	
	@Test
	void testDoFilterInternalForException() throws IOException, ServletException {
		when(request.getHeader("Authorization")).thenReturn("Bearer eFGSsdfergdfDSFSSDF324SDGDFBDFBd");
		TokenResponse tokenResponse = new TokenResponse(true);
		when(restTemplate.postForObject(Mockito.eq(Constant.USER_SERVICE_BASE_URL + "/authenticate/isValidToken"), 
				Mockito.any(TokenRequest.class),Mockito.eq(TokenResponse.class)))
			.thenThrow(RuntimeException.class);
		//doNothing().when(chain).doFilter(request, response);
		assertThrows(Exception.class, ()-> {
			filter.doFilterInternal(request, response, chain);
		});
	}

}
