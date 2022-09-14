package com.patient.exceptio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

@NoArgsConstructor
public class ResourceNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String resourcePropertyName;
	private String resourcePropertyValue;


	public ResourceNotFoundException(String resourceName, String resourcePropertyName, String resourcePropertyValue) {
		super();
		this.resourceName = resourceName;
		this.resourcePropertyName = resourcePropertyName;
		this.resourcePropertyValue = resourcePropertyValue;
	}
	
	public ResourceNotFoundException(String resourceName, String resourcePropertyName, Long resourcePropertyValue) {
		super();
		this.resourceName = resourceName;
		this.resourcePropertyName = resourcePropertyName;
		this.resourcePropertyValue = resourcePropertyValue.toString();
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourcePropertyName() {
		return resourcePropertyName;
	}

	public void setResourcePropertyName(String resourcePropertyName) {
		this.resourcePropertyName = resourcePropertyName;
	}

	public String getResourcePropertyValue() {
		return resourcePropertyValue;
	}

	public void setResourcePropertyValue(String resourcePropertyValue) {
		this.resourcePropertyValue = resourcePropertyValue;
	}
	
	
}
