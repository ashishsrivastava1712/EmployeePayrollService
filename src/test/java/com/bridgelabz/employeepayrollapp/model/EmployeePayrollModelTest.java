
/*
 * File: EmployeePayrollModelTest.java
 * Description: JUnit tests for EmployeePayrollModel constructors,
 *              getters and setters.
 *
 * Name: Ashish Srivastava
 * Date: 16/11/2026
 */

package com.bridgelabz.employeepayrollapp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollModelTest {

    // Test parameterized constructor and getters.
    @Test
    void testParameterizedConstructor() {
        EmployeePayrollModel employee =
                new EmployeePayrollModel("Lisa", 2000);

        assertEquals("Lisa", employee.getName());
        assertEquals(2000, employee.getSalary());
    }

    // Test default constructor and setters.
    @Test
    void testDefaultConstructorAndSetters() {
        EmployeePayrollModel employee =
                new EmployeePayrollModel();

        employee.setName("John");
        employee.setSalary(3000);

        assertEquals("John", employee.getName());
        assertEquals(3000, employee.getSalary());
    }
}
