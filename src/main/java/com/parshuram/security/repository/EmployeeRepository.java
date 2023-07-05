package com.parshuram.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parshuram.security.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	public Employee findByEmpId(Integer empId);
	
	public List<Employee> findByCity(String city);
	
	
}
