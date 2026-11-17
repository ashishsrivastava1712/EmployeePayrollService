
/*
 * File: EmployeePayrollControllerTest.java
 * Description: JUnit tests for Employee Payroll Controller
 *              with Service Layer integration.
 *
 * Name: Ashish Srivastava
 * Date: 16/11/2026
 */

package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class EmployeePayrollControllerTest {

    private MockMvc mockMvc;

    // Initialize Controller with its Service dependency.
    @BeforeEach
    void setUp() {
        EmployeePayrollService service = new EmployeePayrollService();

        EmployeePayrollController controller =
                new EmployeePayrollController(service);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    // Test service availability endpoint.
    @Test
    void testGetAllEmployees() throws Exception {
        mockMvc.perform(get("/employeepayrollservice/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Employee Payroll Service is running"));
    }

    // Test GET employee by ID.
    @Test
    void testGetEmployeeById() throws Exception {
        mockMvc.perform(get("/employeepayrollservice/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Lisa"))
                .andExpect(jsonPath("$.salary").value(2000));
    }

    // Test POST employee request.
    @Test
    void testCreateEmployee() throws Exception {
        String employeeJson = """
                {
                    "name": "Lisa",
                    "salary": 2000
                }
                """;

        mockMvc.perform(post("/employeepayrollservice/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Lisa"))
                .andExpect(jsonPath("$.salary").value(2000));
    }

    // Test PUT employee request.
    @Test
    void testUpdateEmployee() throws Exception {
        String employeeJson = """
                {
                    "name": "Lisa",
                    "salary": 2500
                }
                """;

        mockMvc.perform(put("/employeepayrollservice/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Lisa"))
                .andExpect(jsonPath("$.salary").value(2500));
    }

    // Test DELETE employee request.
    @Test
    void testDeleteEmployee() throws Exception {
        mockMvc.perform(delete("/employeepayrollservice/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.message")
                        .value("Employee delete request received successfully"));
    }
}
