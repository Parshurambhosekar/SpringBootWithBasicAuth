package com.parshuram.security.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String resourceName;
	private String fieldName;
	private Integer fieldValue;
	private String empName;
	
	public ResourceNotFoundException(String resourceName,String fieldName,String empName) {
		super(String.format("%s is not found with %s : %s",resourceName,fieldName,empName));
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.empName=empName;
		
	}
	
	public ResourceNotFoundException(String resourceName,String fieldName,Integer fieldValue) {
		super(String.format("%s is not found with %s : %s",resourceName,fieldName,fieldValue));
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;	
	}
	
	
	
	
	
	

}
