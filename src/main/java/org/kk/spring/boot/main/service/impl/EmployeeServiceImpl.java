package org.kk.spring.boot.main.service.impl;

import java.util.List;

import org.kk.spring.boot.main.dao.EmployeeDao;
import org.kk.spring.boot.main.entity.Employee;
import org.kk.spring.boot.main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Long saveEmployee(Employee emp) {
		return employeeDao.saveEmployee(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public Employee findEmployeeById(Long empId) {
		return employeeDao.findEmployeeById(empId);
	}

}
