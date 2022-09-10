package com.example.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class EmployeeDetails {

	private Employee employee;
	private int lastYearSalary;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public int getLastYearSalary() {
		return lastYearSalary;
	}

	public void setLastYearSalary(int lastYearSalary) {
		this.lastYearSalary = lastYearSalary;
	}
}
