package com.simplecrm.app;

import java.util.ArrayList;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public Customer getCustomer(Long id);
    public ArrayList<Customer> getAllCustomers();
    public Customer updateCustomer(Long id, Customer customer);
    public void deleteCustomer(Long id);
    public Interaction createInteractionToCustomer(Long id, Interaction interaction);
}
 