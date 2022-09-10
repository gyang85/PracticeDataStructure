package com.example.SpringDemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import com.example.models.Customer;

@ComponentScan(basePackages= {"com.example"})
@SpringBootApplication
public class SpringDemoApplication {

	@Autowired
	ObjectFactory<Customer> customerData;
	
	@PostConstruct
	public void initialize() {
		Customer customer1 = customerData.getObject();
		Customer customer2 = customerData.getObject();
		customer1.setCustomerName("Gyanendra");
		customer2.setCustomerName("Ravi");
		System.out.println("Customer 1 name - "+customer1.getCustomerName());
		System.out.println("Customer 2 name - "+customer2.getCustomerName());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
