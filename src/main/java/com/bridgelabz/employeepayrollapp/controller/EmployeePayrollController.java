
/*
 * File: EmployeePayrollController.java
 * Description: REST Controller that delegates Employee Payroll
 *              operations to the Service Layer.
 *
 * Name: Ashish Srivastava
 * Date: 16/11/2026
 */

package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    private final EmployeePayrollService employeePayrollService;

    // Inject the Service object using Spring Dependency Injection.
    @Autowired
    public EmployeePayrollController(
            EmployeePayrollService employeePayrollService) {

        this.employeePayrollService = employeePayrollService;
    }

    // GET: Check whether the Employee Payroll service is running.
    @GetMapping("/")
    public ResponseEntity<Map<String, String>> getAllEmployees() {
        return ResponseEntity.ok(
                Map.of("message", "Employee Payroll Service is running")
        );
    }

    // GET by ID: Delegate employee retrieval to the Service Layer.
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollModel> getEmployeeById(
            @PathVariable("id") int id) {

        EmployeePayrollModel employee =
                employeePayrollService.getEmployeePayrollDataById(id);

        return ResponseEntity.ok(employee);
    }

    // POST: Delegate employee creation to the Service Layer.
    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollModel> createEmployee(
            @RequestBody EmployeePayrollDTO employeeDTO) {

        EmployeePayrollModel employee =
                employeePayrollService.addEmployeePayrollData(employeeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    // PUT: Delegate employee update to the Service Layer.
    @PutMapping("/update")
    public ResponseEntity<EmployeePayrollModel> updateEmployee(
            @RequestBody EmployeePayrollDTO employeeDTO) {

        EmployeePayrollModel employee =
                employeePayrollService.updateEmployeePayrollData(employeeDTO);

        return ResponseEntity.ok(employee);
    }

    // DELETE: Delegate delete request handling to the Service Layer.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(
            @PathVariable("id") int id) {

        Map<String, Object> response =
                employeePayrollService.deleteEmployeePayrollData(id);

        return ResponseEntity.ok(response);
    }
}
