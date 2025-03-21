package com.hibernate.crud.crud_operations_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.crud.crud_operations_api.dao.EmployeeDao;
import com.hibernate.crud.crud_operations_api.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;

	public Employee insertEmployee(Employee employee) {
		return dao.save(employee);
	}

	public List<Employee> getAllEmployee() {
		return dao.getAllEmployeess();
		
	}

	public String deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployeeById(id);
	}

	public Employee updateEmployeeById(Long id,Employee employee) {
		return dao.updateEmployee(id,employee);
	}

}
