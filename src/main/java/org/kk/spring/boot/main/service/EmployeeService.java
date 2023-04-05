package org.kk.spring.boot.main.service;

import java.util.List;

import org.kk.spring.boot.main.entity.Employee;

public interface EmployeeService {

	public Long saveEmployee(Employee emp);
	
	public List<Employee> getAllEmployee();
	
	public Employee findEmployeeById(Long empId);
}
