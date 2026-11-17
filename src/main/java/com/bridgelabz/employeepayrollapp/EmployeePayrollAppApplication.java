
/*
 * File: EmployeePayrollAppApplication.java
 * Description: Main entry point of the Employee Payroll Spring Boot
 * application. It starts the Spring Boot application and initializes
 * the Spring application context.
 *
 * Name: Ashish Srivastava
 * Date: 16/11/2026
 */

package com.bridgelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Enables Spring Boot auto-configuration and component scanning.
@SpringBootApplication
public class EmployeePayrollAppApplication {

	// Main method to launch the Employee Payroll application.
	public static void main(String[] args) {

		SpringApplication.run(EmployeePayrollAppApplication.class, args);
	}
}
