package com.sparta.mz.abstractclasses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeTests {
    @Test
    @DisplayName("check test employee credentials")
    public void checkEmployeeName() {
        Employee employee = new Employee("Test", "Employee") {
            @Override
            public short print() {
                return 0;
            }
        };
        String fullName = employee.getFirstName() + " " + employee.getLastName();
        Assertions.assertEquals(fullName, "Test Employee");
    }
}
