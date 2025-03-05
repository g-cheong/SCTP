package com.simplecrm.app;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class oldCustomerRepository {
    private ArrayList<Customer> customers = new ArrayList<>();

    public oldCustomerRepository() {
        Customer bruce = Customer.builder().firstName("Bruce").lastName("Banner").build();
        Customer peter = Customer.builder().firstName("Peter").lastName("Parker").build();
        customers.add(bruce);
        customers.add(peter);
        customers.add(Customer.builder().firstName("Tony").lastName("Stark").build());
        customers.add(Customer.builder().firstName("Steve").lastName("Rogers").build());
    };

    public Customer createCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    public Customer updateCustomer(int index, Customer customer) {
        Customer updatedCustomer = customers.set(index, customer);
        return updatedCustomer;
    }

    public void deleteCustomer(int index) {
        customers.remove(index);
    }   
}
