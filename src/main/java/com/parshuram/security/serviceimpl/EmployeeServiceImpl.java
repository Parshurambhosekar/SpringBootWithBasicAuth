package com.parshuram.security.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parshuram.security.entity.Employee;
import com.parshuram.security.exception.ResourceNotFoundException;
import com.parshuram.security.repository.EmployeeRepository;
import com.parshuram.security.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addNewEmployee(Employee employee) {
		
		Employee emp = employeeRepository.save(employee);
	
		return emp;
	}

	@Override
	public Employee updateEmployee(Integer empId, Employee employee) {
	
		Employee emp = employeeRepository.findByEmpId(empId);
		
		if(emp==null) {
			throw new ResourceNotFoundException("Employee", "empId", empId);
		}
		else {
			emp.setId(employee.getId());
			emp.setEmpId(employee.getEmpId());
			emp.setName(employee.getName());
			emp.setCity(employee.getCity());
			emp.setSalary(employee.getSalary());
			
			Employee updatedEmployee = employeeRepository.save(emp);
			
			return updatedEmployee;
		}	
	}

	@Override
	public List<Employee> getAllEmpDetails() {
		
		List<Employee> allEmp = employeeRepository.findAll();
		
		return allEmp;
	}

	@Override
	public void deleteEmployee(Integer empId) {
		
		Employee findByEmpId = employeeRepository.findByEmpId(empId);
		
		if(findByEmpId==null) {
			throw new ResourceNotFoundException("Employee", "empId", empId);
		}
		else {
			
			employeeRepository.delete(findByEmpId);
		}
	
	}

	@Override
	public Employee getEmployeeByName(String name) {

		List<Employee> allEmp = employeeRepository.findAll();
		
		Employee employee = allEmp.stream().filter(e->e.getName().equalsIgnoreCase(name))
						.findAny().orElseThrow(()->new ResourceNotFoundException("Employee", "empName", name));
		
		return employee;
	}

	@Override
	public List<Employee> getEmployeeByCity(String city) {
		
		List<Employee> findByCity = employeeRepository.findByCity(city);
		
		if(findByCity.isEmpty()) {
			
			throw new ResourceNotFoundException("Employee", "empCity", city);
		}
		
		return findByCity;
	}

}
