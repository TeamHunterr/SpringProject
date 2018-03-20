package com.journaldev.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.journaldev.spring.dao.EmployeeDAO;
import com.journaldev.spring.model.Employee;

@Qualifier("employeeService")
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDAO;

	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public void addEmployee(Employee p) {
		employeeDAO.addEmployee(p);
		
	}

	@Override
	@Transactional
	public void updateEmployee(Employee p) {
		employeeDAO.updateEmployee(p);
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return this.employeeDAO.listEmployee();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return this.employeeDAO.getEmployeeById(id);
	}

	@Override
	@Transactional
	public void removeEmployee(int id) {
		
		this.employeeDAO.removeEmployee(id);
	}

}
