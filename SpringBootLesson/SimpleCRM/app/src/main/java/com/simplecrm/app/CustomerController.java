package com.simplecrm.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    Customer customer;

    @GetMapping("/customer")
    public Customer getCustomer() {
        customer.setId(1);
        customer.setFirstName("The");
        customer.setLastName("Rock");
        customer.setEmail("jabroni@whatscooking.com");
        customer.setContactNo("1800-@55-Whooping");
        customer.setJobTitle("The People's Champion");
        customer.setYearOfBirth(1972);
        return customer;
    }
}
