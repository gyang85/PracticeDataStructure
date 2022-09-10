package com.example.service;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Employee;
import com.example.models.EmployeeDetails;
import com.example.models.RandomUtil;

@Service
public class AppService {
    
	@Autowired
    private ObjectFactory<EmployeeDetails> employeeDetailsProvider;

    public EmployeeDetails findEmployeeSalary() {
        EmployeeDetails employeeDetails = employeeDetailsProvider.getObject();
        Employee employee = employeeDetails.getEmployee();
        employeeDetails.setLastYearSalary(getEmployeeSalary(employee));
        return employeeDetails;
    }

    private int getEmployeeSalary(Employee employee) {
        int salary = 100 * RandomUtil.getInt(30, 100);
        return salary;
    }
}