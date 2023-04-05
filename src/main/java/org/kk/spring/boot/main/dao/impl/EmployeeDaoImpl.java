package org.kk.spring.boot.main.dao.impl;

import java.util.List;

import org.kk.spring.boot.main.dao.EmployeeDao;
import org.kk.spring.boot.main.entity.Employee;
import org.kk.spring.boot.main.repository.EmployeeReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private EmployeeReposistory employeeReposistory;
	
	@Override
	public Long saveEmployee(Employee emp) {
		return employeeReposistory.save(emp).getEmpId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeReposistory.findAll();
	}

	@Override
	public Employee findEmployeeById(Long empId) {
		return employeeReposistory.getOne(empId);
	}

	

}
