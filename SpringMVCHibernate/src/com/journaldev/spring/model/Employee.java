package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;

	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	
	@Column(name="PHONE_NUMBER")
	private String phoneNo;
	
	
	@Column(name="HIRE_DATE")
	private String hireDate;
	
	
	@Column(name="JOB_ID")
	private String jobId;
	
	
	@Column(name="SALARY")
	private int salary;
	
	
	@Column(name="COMMISSION_PCT")
	private int commissionPct;
	
	
	@Column(name="MANAGER_ID")
	private int managerId;
	
	
	@Column(name="DEPARTMENT_ID")
	private int departmentId;
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = "XYZ";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = "17-06-87";
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = "IT_PROG";
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(int commissionPct) {
		this.commissionPct = commissionPct;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString(){
		return "FIRST_NAME="+firstName;
	}
	
	

}
