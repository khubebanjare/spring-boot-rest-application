package org.kk.spring.boot.main.controller;

import java.util.List;
import java.util.Optional;

import org.kk.spring.boot.main.SwaggerConfigValue;
import org.kk.spring.boot.main.entity.Employee;
import org.kk.spring.boot.main.exception.EmployeeNotFoundException;
import org.kk.spring.boot.main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/rest/api", produces="application/json")
@Api(tags = {"Employee Controller"})
@ApiResponses( value = {
		@ApiResponse(message = SwaggerConfigValue.OK, code = 200),
		@ApiResponse(message = SwaggerConfigValue.CREATED, code = 201),
		@ApiResponse(message = SwaggerConfigValue.FORBIDDEN, code = 404),
		@ApiResponse(message = SwaggerConfigValue.NOTFOUND, code = 400),
		@ApiResponse(message = SwaggerConfigValue.UNATHOURISED, code = 401),
		@ApiResponse(message = SwaggerConfigValue.INTERNALSERVERERROR, code = 500)
})
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/employees/save", produces = "application/json")
	@ApiOperation(value = SwaggerConfigValue.VALUE1, response = String.class)
	public String saveStudent(@RequestBody Employee emp) {
		Long empId = employeeService.saveEmployee(emp);
		return "Employee is saved id : " + empId + ", sucessfully.";
	}
	
	@GetMapping(value = "/employees", produces = "application/json")
	@ApiOperation(value = SwaggerConfigValue.VALUE2, response = List.class)
	public List<Employee> getAllEmployee(){
		List<Employee> employees = employeeService.getAllEmployee();
		
		if(employees == null) {
			throw new EmployeeNotFoundException("Employee ie Empty");
		}
		
		return employees;
	}
	
	@GetMapping(value = "/employees/{empId}", produces = "application/json")
	public String getEmployeeById(@PathVariable("empId") Long empId) {
		Optional<Employee> employee = null; 
		employeeService.findEmployeeById(empId);
		if(employee.isPresent()) {
			employee.get();
		}
		else {
			throw new EmployeeNotFoundException("Employee is empty for this Employee Id : " + empId);
		}
		return "Employee : " + employee;
	}
}
