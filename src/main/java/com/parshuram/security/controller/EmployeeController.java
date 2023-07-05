package com.parshuram.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parshuram.security.entity.Employee;
import com.parshuram.security.exception.ApiResponse;
import com.parshuram.security.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		Employee newEmployee = employeeService.addNewEmployee(employee);
		
		return new ResponseEntity<Employee>(newEmployee,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "id") Integer empId,@RequestBody Employee employee){
		
		Employee updateEmployee = employeeService.updateEmployee(empId, employee);
		
		return new ResponseEntity<Employee>(updateEmployee, HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployeeDetails(){
		
		List<Employee> empDetails = employeeService.getAllEmpDetails();
		
		return new ResponseEntity<List<Employee>>(empDetails, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable(name="id") Integer empId){
		
		employeeService.deleteEmployee(empId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully..", true), HttpStatus.OK);
		
	}
	
	@GetMapping("/emp/{name}")
	public ResponseEntity<Employee> getEmpByName(@PathVariable(name = "name") String name){
		
		Employee employee = employeeService.getEmployeeByName(name);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);	
	}
	
	@GetMapping("/eCity/{city}")
	public ResponseEntity<List<Employee>> getEmpByCity(@PathVariable(name = "city") String city){
		
		List<Employee> empAllCity = employeeService.getEmployeeByCity(city);
		
		return new ResponseEntity<List<Employee>>(empAllCity, HttpStatus.OK);
	}
		
}
