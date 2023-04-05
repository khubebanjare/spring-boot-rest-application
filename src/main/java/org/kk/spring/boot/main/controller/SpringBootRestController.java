package org.kk.spring.boot.main.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpringBootRestController {

	@Value("${emp.code}")
	private String empCode;
	
	@GetMapping("/getCode")
	public String getCode() {
		return empCode;
	}
}
