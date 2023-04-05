package org.kk.spring.boot.main.repository;

import org.kk.spring.boot.main.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReposistory extends JpaRepository<Employee, Long>{

}
