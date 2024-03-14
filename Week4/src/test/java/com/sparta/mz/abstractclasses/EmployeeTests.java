package com.sparta.mz.abstractclasses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeTests {
    @Test
    @DisplayName("check test employee credentials")
    public void givenAnEmployeeCheckDeleteMethod() {
        Employee testEmployee = new Employee("Test", "Employee") {
            @Override
            public void print() {
                System.out.println("Testing");
            }
        };
        Assertions.assertEquals(testEmployee.getFirstName(), "Test");
    }
    
}
