package com.parshuram.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee_Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Sr_No.")
	private Integer id;
	private Integer empId;
	@Column(name = "EmpName")
	private String name;
	@Column(name = "EmpCity")
	private String city;
	@Column(name = "EmpSalary")
	private Long salary;


}
