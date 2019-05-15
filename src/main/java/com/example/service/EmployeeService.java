package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.entity.Employee;

public interface EmployeeService {
	Map<String,Object> addNewEmployee(Employee employee);
	
	Employee getEmployeeById(Integer id) throws Exception;
	
	Map<String, Object> updateEmployee(Integer id, Employee employeeDetails);
	
	Map<String, Object> deleteEmployee(Integer id);
	
	List<Employee> getAllEmployees();
	
	
}
