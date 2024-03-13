package com.sparta.mz.testfirstdevelopment;

import com.sparta.mz.uml.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTests {
    @Test
    @DisplayName("Test getting and setting the delivery address")
    public void testDeliveryAddressGetterAndSetter() {
        String expectedDeliveryAddress = "London";
        Customer customer = new Customer("Alice", "Smith", "Manchester");

        customer.setDeliveryAddress(expectedDeliveryAddress);
        String actualDeliveryAddress = customer.getDeliveryAddress();

        Assertions.assertEquals(expectedDeliveryAddress, actualDeliveryAddress);
    }

    @Test
    @DisplayName("Test getting details after setting first name, last name, and delivery address")
    public void testGetDetailsAfterSettingAllFields() {
        String expectedFirstName = "Alice";
        String expectedLastName = "Smith";
        String expectedDeliveryAddress = "London";
        String expectedDetails = "Delivery Address: London, First Name: Alice, Last Name: Smith";

        Customer customer = new Customer("Bob", "Johnson", "Manchester");
        customer.setFirstName(expectedFirstName);
        customer.setLastName(expectedLastName);
        customer.setDeliveryAddress(expectedDeliveryAddress);

        String actualDetails = customer.getDetails();

        Assertions.assertEquals(expectedDetails, actualDetails);
    }
}