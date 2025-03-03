package com.simplecrm.app;

import java.util.ArrayList;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public Customer getCustomer(String id);
    public ArrayList<Customer> getAllCustomers();
    public Customer updateCustomer(String id, Customer customer);
    public void deleteCustomer(String id);
}
