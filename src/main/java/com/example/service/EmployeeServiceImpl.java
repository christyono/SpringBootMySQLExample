package com.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeRepository;
import com.example.entity.Employee;
import com.example.exception.EmployeeNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Override
	public Map<String, Object> addNewEmployee(Employee employee) {
		ObjectMapper objectMapper = new ObjectMapper();
        Employee e = employeeRepository.save(employee);
        Map<String,Object> responseMap = objectMapper.convertValue(e, new TypeReference<Map<String, Object>>() {});
        responseMap.put("message", "Employee successfully added!");
        return responseMap;
	}


	@Override
	public Employee getEmployeeById(Integer id) throws Exception {
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("id", id));
	}


	@Override
	public Map<String, Object> updateEmployee(Integer id, Employee employeeDetails) {
	    Employee e = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("id", id));
	    e.setName(employeeDetails.getName());
	    e.setPhone(employeeDetails.getPhone());
	    
	    Employee newEmp = employeeRepository.save(e);
		ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> responseMap = objectMapper.convertValue(newEmp, new TypeReference<Map<String, Object>>() {});
        responseMap.put("message", "Employee successfully updated!");
        return responseMap;
	}


	@Override
	public Map<String, Object> deleteEmployee(Integer id) {
	    Employee e = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("id", id));
	    employeeRepository.delete(e);
		ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> responseMap = objectMapper.convertValue(e, new TypeReference<Map<String, Object>>() {});
        responseMap.put("message", "Employee successfully deleted!");
        return responseMap;

	}


	@Override
	public List<Employee> getAllEmployees() {
		return Lists.newArrayList(employeeRepository.findAll());
	}
	
}
