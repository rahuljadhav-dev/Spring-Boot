package com.hibernate.crud.crud_operations_api.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.crud.crud_operations_api.entity.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	private SessionFactory factory;

	public Employee save(Employee employee) {
		Session session=null;
		Transaction transaction=null;
		
		try {
			session=factory.openSession();
			transaction=session.beginTransaction();
			
			session.persist(employee);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Error occurs");
		
		}
		return employee;
	}

	public List<Employee> getAllEmployeess() {
		Session session=null;
		try {
			session=factory.openSession();
			
			Query query= session.createQuery("From Employee");
			List<Employee> list=query.list();
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String deleteEmployeeById(Long id) {
		Session session=null;
		Transaction transaction=null;
		
		try {
			session=factory.openSession();
			transaction=session.beginTransaction();
			Employee e=session.get(Employee.class, id);
			if(e!=null) {
				session.delete(e);
				transaction.commit();
			}
		
			return "Employee Deleted...";
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
		return null;
	}

	public Employee updateEmployee(Long id,Employee employee) {
		Session session=null;
		Transaction transaction=null;
		
		try {
			session=factory.openSession();
			transaction=session.beginTransaction();
			
			Employee optional=session.get(Employee.class, id);
			
			if(optional!=null) {
//				optional.setId(employee.getId());
				optional.setDomain(employee.getDomain());
				optional.setName(employee.getName());
				optional.setSalary(employee.getSalary());
				
				session.update(optional);
				transaction.commit();
				session.close();
				
				return optional;
			}else
				return null;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

}
