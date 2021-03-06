package za.ac.cput.repository;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 1 April 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;
//import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class CustomerRepositoryTest {
    private static CustomerRepository customerRepository = CustomerRepository.getInstance();
    private static Customer customer_a = CustomerFactory.addCustomer(4,"John","Doe","Cat street"
            ,911414112);

    @Test
    void a_CreateTest(){
        Customer customer1 = customerRepository.create(customer_a);
        Customer customer2 = customer1;
        Customer customer_b = CustomerFactory.addCustomer(1,"Tom","Cat","Cat Ave",
                123456789);

        assertEquals(customer_a.getCustomerID(),customer1.getCustomerID());
        assertSame(customer_a.getCustomerID(),customer1.getCustomerID());
        assertNotSame(customer1.getCustomerID(),customer_b.getCustomerID());
        assertNotSame(customer2.getCellNo(),customer_b.getCellNo());
        assertSame(customer1,customer2);
        assertNotSame(customer1,customer_b);
        assertNotNull(customer_a);
        assertNotNull(customer2);
        assertNotNull(customer_b);
        //assertNull(customer_a); //test fails
        System.out.println("Customer(s) added...");
        System.out.println();

    }

    @Test
    void b_ReadCustomerTest(){
        Customer showCustomer1 = customerRepository.read(customer_a.getCustomerID());
        Customer showCustomer2 = showCustomer1;
        Customer showCustomer3 = CustomerFactory.addCustomer(202,"Will","Smith",
                "Disney street",240202221);

        assertNotNull(showCustomer1);
        assertNotNull(showCustomer3);
        assertNotSame(showCustomer1.getCustomerID(),showCustomer3.getCustomerID());
        assertNotSame(showCustomer1,showCustomer3);
        assertSame(showCustomer1.getCustomerID(),customer_a.getCustomerID());
        assertSame(showCustomer1,showCustomer2);
        assertEquals(customer_a.getCustomerID(),showCustomer1.getCustomerID());

        System.out.println("Read from list...");
        System.out.println(customerRepository.read(4));
        System.out.println();

    }

    @Test
    void c_UpdateCustomerTest(){
        Customer updateCustomer1 = new Customer.Builder().copy(customer_a)
                .setCustomerSurname("Johnson")
                .setAddress("Elm street")
                .build();
        Customer identicalCustomer = updateCustomer1;

        assertNotNull(updateCustomer1);
        assertNotNull(identicalCustomer);
        assertSame(updateCustomer1,identicalCustomer);
        assertEquals(customer_a.getCustomerID(),updateCustomer1.getCustomerID());
        assertNotSame(customer_a,updateCustomer1);
        assertNotSame(customer_a.getCustomerSurname(),updateCustomer1.getCustomerSurname());
        assertNotSame(customer_a.getAddress(),updateCustomer1.getAddress());
        //assertSame(customer_a,updateCustomer1); //fails the test
        System.out.println("Customer details updated...");
        System.out.println(customerRepository.update(updateCustomer1));
        System.out.println();

    }

    @Test
    void e_DeleteCustomerTest(){
        boolean success = CustomerRepository.getInstance().delete((customer_a.getCustomerID()));
        assertNotNull(success);
        assertNotSame(customer_a,success);
        //assertSame(customer_a,success); //fails test because the deletion has been success, and therefore it is not the same
        System.out.println("Delete success? " + success);
        System.out.println();
    }

    @Test
    void d_getAllTest(){
        System.out.println("Getting all: ");
        assertNotNull(customerRepository.getAll());
        System.out.println(customerRepository.getAll());
        System.out.println();
    }
}