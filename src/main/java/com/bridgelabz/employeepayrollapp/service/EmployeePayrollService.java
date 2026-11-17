
/*
 * File: EmployeePayrollService.java
 * Description: Service layer responsible for managing
 *              Employee Payroll Model objects.
 *
 * Name: Ashish Srivastava
 * Date: 16/11/2026
 */

package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeePayrollService {

    // Return a sample employee model for the requested ID.
    public EmployeePayrollModel getEmployeePayrollDataById(int id) {
        return new EmployeePayrollModel("Lisa", 2000);
    }

    // Convert DTO data into a Model object.
    public EmployeePayrollModel addEmployeePayrollData(
            EmployeePayrollDTO employeeDTO) {

        return new EmployeePayrollModel(
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );
    }

    // Convert updated DTO data into a Model object.
    public EmployeePayrollModel updateEmployeePayrollData(
            EmployeePayrollDTO employeeDTO) {

        return new EmployeePayrollModel(
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );
    }

    // Return a response for the delete request.
    public Map<String, Object> deleteEmployeePayrollData(int id) {
        return Map.of(
                "message", "Employee delete request received successfully",
                "id", id
        );
    }
}
