package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.dao.EmployeeRepository;
import com.example.entity.Employee;
import com.example.exception.EmployeeNotFoundException;
import com.example.service.EmployeeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;
	
	//Create
	@PostMapping(path="/add") 
	public ResponseEntity<?> addNewEmployee (@Valid @RequestBody Employee employee) {
		Map<String, Object> responseMap = employeeService.addNewEmployee(employee);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}
	
	//Read (by id)
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable(value="id") Integer id) throws Exception {
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	//Update (by id)
	@PutMapping(path="/update/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable(value = "id") Integer id, 
			@Valid @RequestBody Employee employeeDetails) {
		Map<String, Object> responseMap = employeeService.updateEmployee(id, employeeDetails);
	    return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}
	
	//Delete (by id)
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Integer id){
		Map<String, Object> responseMap = employeeService.deleteEmployee(id);
	    return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}
	
	//Read (all employees)
	@GetMapping(path="/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
}
