package za.ac.cput.factory;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 29 March 2022
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Customer;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    public void addCustomerTest(){
        //test to add a new customer
        Customer testNewCustomer = CustomerFactory.addCustomer(121,"a","b","c",123456789);
        System.out.println("User has been added...");
        assertNotNull(testNewCustomer);
        //assertNull(testNewCustomer); //failed test
    }

    @Test
    public void showCustomer(){
        //Test for "not null" and show the added customer
        Customer testViewCustomer = CustomerFactory.addCustomer(121,"a","b","c",123456789);
        System.out.println(testViewCustomer.toString());
        assertNotNull(testViewCustomer);
    }

    @Test
    public void testObjectIdentity(){
        //Testing object identity
        Customer testViewCustomer1 = CustomerFactory.addCustomer(121,"a","b","c",123456789);
        Customer testViewCustomer2 = CustomerFactory.addCustomer(120,"d","e","f",1098765432);
        Customer testViewCustomer3 = testViewCustomer1;

            assertSame(testViewCustomer1,testViewCustomer3);

            assertNotSame(testViewCustomer1.getCustomerID(),testViewCustomer2.getCustomerID());
            assertNotSame(testViewCustomer1.getCustomerName(),testViewCustomer2.getCustomerName());
            assertNotSame(testViewCustomer1.getCustomerSurname(),testViewCustomer2.getCustomerSurname());
            assertNotSame(testViewCustomer1.getAddress(),testViewCustomer2.getAddress());
            assertNotSame(testViewCustomer1.getCellNo(),testViewCustomer2.getCellNo());
            assertNotSame(testViewCustomer1, testViewCustomer2);
            assertNotSame(testViewCustomer2, testViewCustomer1);
            assertNotSame(testViewCustomer2, testViewCustomer3);
            System.out.println("Tests passed!...");
        }

        @Test
    public void testObjectEquality(){
        //test object equality
        Customer testViewCustomer1 = CustomerFactory.addCustomer(121,"a","b","c",123456789);
        Customer testViewCustomer2 = CustomerFactory.addCustomer(120,"d","e","f",1098765432);
        Customer testViewCustomer3 = testViewCustomer1;
        Customer testViewCustomer4 = testViewCustomer2;

        assertEquals(testViewCustomer1,testViewCustomer3);
        assertEquals(testViewCustomer2,testViewCustomer4);
        assertEquals(testViewCustomer1.getCustomerID(),testViewCustomer3.getCustomerID());
        assertEquals(testViewCustomer1.getCustomerName(),testViewCustomer3.getCustomerName());
        assertEquals(testViewCustomer1.getCustomerSurname(),testViewCustomer3.getCustomerSurname());
        assertEquals(testViewCustomer1.getAddress(),testViewCustomer3.getAddress());
        assertEquals(testViewCustomer1.getCellNo(),testViewCustomer3.getCellNo());

        assertNotEquals(testViewCustomer1.getCustomerID(),testViewCustomer2.getCustomerID());
        assertNotEquals(testViewCustomer1.getCustomerName(),testViewCustomer2.getCustomerName());
        assertNotEquals(testViewCustomer1.getCustomerSurname(),testViewCustomer2.getCustomerSurname());
        assertNotEquals(testViewCustomer1.getAddress(),testViewCustomer2.getAddress());
        assertNotEquals(testViewCustomer1.getCellNo(),testViewCustomer2.getCellNo());
        assertNotEquals(testViewCustomer1.getCellNo(),testViewCustomer2.getCellNo());
        System.out.println("Test passed!...");

    }

}