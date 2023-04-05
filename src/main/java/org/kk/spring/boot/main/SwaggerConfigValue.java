package org.kk.spring.boot.main;

import lombok.Data;

@Data
public class SwaggerConfigValue {
	
	public static final String VALUE1 = "This api is used to create an employee";
	
	public final static String VALUE2 = "This Api is used to get Employees Details";
	
	public final static String OK = "It is okay";
	
	public static final String CREATED = "It is created";
	public static final String NOTFOUND = "Employee Not Found";
	public static final String FORBIDDEN = "FORBIDDEN";
	public static final String UNATHOURISED = "UNATHOURISED";
	public static final String INTERNALSERVERERROR = "Internal Server Error";
}
