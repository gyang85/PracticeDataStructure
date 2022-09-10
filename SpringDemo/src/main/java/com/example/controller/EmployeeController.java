package com.example.controller;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Employee;
import com.example.models.EmployeeDetails;
import com.example.models.RandomUtil;
import com.example.service.AppService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
    private ObjectFactory<EmployeeDetails> employeeDetailsProvider;
	
	@Autowired
    private ObjectFactory<Employee> employee;
	
	@Autowired
    AppService appService;

    @RequestMapping("/{id}")
    public EmployeeDetails handler(@PathVariable("id") String employeeId) {
    	EmployeeDetails employeeDetails = employeeDetailsProvider.getObject();
    	System.out.println(employeeDetails);
    	employeeDetails.setEmployee(getEmployeeById(employeeId));
        return appService.findEmployeeSalary();
    }

    private Employee getEmployeeById(String employeeId) {
        return new Employee(employeeId, RandomUtil.getFullName(),
                RandomUtil.getAnyOf("Admin", "IT", "Sales"));
    }
}
