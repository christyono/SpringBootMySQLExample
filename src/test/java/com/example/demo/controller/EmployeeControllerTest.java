package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.controller.EmployeeController;
import com.example.dao.EmployeeRepository;
import com.example.entity.Employee;
import com.example.service.EmployeeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest (controllers=EmployeeController.class)
public class EmployeeControllerTest {
	@MockBean
	private EmployeeRepository eRepo;
	@MockBean
	private EmployeeService eService;
	@InjectMocks
	private EmployeeController eController;
	@Autowired
	private MockMvc mockMvc;
	private Employee e1; private Employee e2;

	public void e1() {
		e1 = new Employee();
		e1.setId(1);
		e1.setName("Wes");
		e1.setPhone("1234567890");
	}
	public void e2() {
		e2 = new Employee();
		e2.setId(2);
		e2.setName("Tom");
		e2.setPhone("0987654321");
	}

	@Before
	public void setup() {
		e1();e2();
	}
	
	@Test
	public void verifyNewEmployee() throws Exception{
		String json = "{\"name\":\"Wesley\",\"phone\":\"1234567890\"}";
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/employee/add")
					.contentType(MediaType.APPLICATION_JSON)
					.content(json))
					.andExpect(status().isOk());
	}
	
	@Test
	public void verifyEmployeeById() throws Exception{
		String json = "{\"name\":\"Wesley\",\"phone\":\"1234567890\"}";
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/employee/add")
					.contentType(MediaType.APPLICATION_JSON)
					.content(json));
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/1")).andExpect(status().isOk());
	}
	
	public void verifyUpdateEmployee() throws Exception{
		String json = "{\"name\":\"Wesley\",\"phone\":\"1234567890\"}";
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/employee/add")
					.contentType(MediaType.APPLICATION_JSON)
					.content(json));

		String json2 = "{\"name\":\"Fred\",\"phone\":\"9234567891\"}";
		
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/employee/update/1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(json2))
					.andExpect(status().isOk());
	}
	
	public void verifyDeleteEmployee() throws Exception{
		String json = "{\"name\":\"Wesley\",\"phone\":\"1234567890\"}";
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/employee/add")
					.contentType(MediaType.APPLICATION_JSON)
					.content(json));

		this.mockMvc.perform(
				MockMvcRequestBuilders.delete("/employee/1")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());

	}
	
	
	
}
