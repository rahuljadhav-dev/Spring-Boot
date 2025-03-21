package com.hibernate.crud.crud_operations_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.crud.crud_operations_api.entity.Employee;
import com.hibernate.crud.crud_operations_api.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/register")
	public Employee register(@RequestBody Employee employee) {
		return service.insertEmployee(employee);
	}
	
	@GetMapping("/show")
	public List<Employee>getAllEmployee(){
		return service.getAllEmployee();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id")Long id ) {
		return service.deleteEmployeeById(id);
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable("id")Long id, @RequestBody Employee employee) {
		return service.updateEmployeeById(id,employee);
	}

}
