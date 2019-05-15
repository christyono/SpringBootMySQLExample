package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
