package com.admin.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.admin.dto.TokenRequest;
import com.admin.dto.TokenResponse;
import com.admin.util.Constant;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	RestTemplate restTemplate;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);

			try {
			TokenResponse tokenResponse = restTemplate.postForObject(
					Constant.USER_SERVICE_BASE_URL + "/authenticate/isValidToken", new TokenRequest(jwtToken),
					TokenResponse.class);
			
			if (!ObjectUtils.isEmpty(tokenResponse)) {
				if (tokenResponse.isValid()) {
					response.setHeader("token", jwtToken);
					chain.doFilter(request, response);
				}
			}
			}catch(Unauthorized ex) {
				log.error(ex.getMessage());
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
			}
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		}

	}
}
