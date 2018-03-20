package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEmployee(Employee p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
		
	}

	@Override
	public void updateEmployee(Employee p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployee() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> personsList = session.createQuery("from Employee").list();
		
		for(Employee p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Employee p = (Employee) session.load(Employee.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee p = (Employee) session.load(Employee.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
		
	}

}
