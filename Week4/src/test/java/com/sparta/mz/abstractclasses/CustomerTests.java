package com.sparta.mz.abstractclasses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTests {
    Customer customer = new Customer("Test", "Customer");

    @Test
    @DisplayName("check customer has valid name")
    public void checkCustomerName() {
        String fullName = customer.getFirstName() + " " + customer.getLastName();
        Assertions.assertEquals(fullName, "Test Customer");
    }

    @Test
    @DisplayName("update customer's first name")
    public void updateCustomerFirstName() {
        customer.setFirstName("Updated");
        String fullName = customer.getFirstName() + " " + customer.getLastName();
        Assertions.assertEquals(fullName, "Updated Customer");
    }

    @Test
    @DisplayName("update customer's last name")
    public void updateCustomerLastName() {
        customer.setLastName("Updated");
        String fullName = customer.getFirstName() + " " + customer.getLastName();
        Assertions.assertEquals(fullName, "Test Updated");
    }
}
