package com.parshuram.security.service;

import com.parshuram.security.entity.Employee;
import java.util.List;

public interface EmployeeService {
	
	public Employee addNewEmployee(Employee employee);
	
	public Employee updateEmployee(Integer empId,Employee employee);
	
	public List<Employee> getAllEmpDetails();
	
	public void deleteEmployee(Integer empId);
	
	public Employee getEmployeeByName(String name);
	
	public List<Employee> getEmployeeByCity(String city);

}
