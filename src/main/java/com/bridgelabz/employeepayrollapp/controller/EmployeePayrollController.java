
/*
 * File: EmployeePayrollController.java
 * Description: REST Controller demonstrating HTTP methods
 *              using EmployeePayrollDTO and EmployeePayrollModel.
 *
 * Name: Ashish Srivastava
 * Date: 16/11/2026
 */

package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // GET: Check whether the Employee Payroll service is running.
    @GetMapping("/")
    public ResponseEntity<Map<String, String>> getAllEmployees() {
        return ResponseEntity.ok(
                Map.of("message", "Employee Payroll Service is running")
        );
    }

    // GET by ID: Return sample employee model data.
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollModel> getEmployeeById(
            @PathVariable("id") int id) {

        EmployeePayrollModel employee =
                new EmployeePayrollModel("Lisa", 2000);

        return ResponseEntity.ok(employee);
    }

    // POST: Receive DTO and return the corresponding Model.
    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollModel> createEmployee(
            @RequestBody EmployeePayrollDTO employeeDTO) {

        EmployeePayrollModel employee = new EmployeePayrollModel(
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employee);
    }

    // PUT: Receive updated DTO and return the corresponding Model.
    @PutMapping("/update")
    public ResponseEntity<EmployeePayrollModel> updateEmployee(
            @RequestBody EmployeePayrollDTO employeeDTO) {

        EmployeePayrollModel employee = new EmployeePayrollModel(
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );

        return ResponseEntity.ok(employee);
    }

    // DELETE: Receive employee ID for the delete request.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(
            @PathVariable("id") int id) {

        return ResponseEntity.ok(
                Map.of(
                        "message", "Employee delete request received successfully",
                        "id", id
                )
        );
    }
}
