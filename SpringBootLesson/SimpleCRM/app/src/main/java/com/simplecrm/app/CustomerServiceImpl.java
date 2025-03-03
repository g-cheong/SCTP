package com.simplecrm.app;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// @Primary
@Service
public class CustomerServiceImpl implements CustomerService {
        private CustomerRepository customerRepository;

        public CustomerServiceImpl(CustomerRepository customerRepository) { 
            this.customerRepository = customerRepository;
        }    

        public Customer createCustomer(Customer customer) {
            return customerRepository.createCustomer(customer);
        }

        public Customer getCustomer(String id) {
            int index = getCustomerIndex(id);
            return customerRepository.getCustomer(index);
        }

        public ArrayList<Customer> getAllCustomers() {
            return customerRepository.getAllCustomers();
        }

        public Customer updateCustomer(String id, Customer customer) {
            int index = getCustomerIndex(id);
            return customerRepository.updateCustomer(index, customer);
        }

        public void deleteCustomer(String id) {
            int index = getCustomerIndex(id);
            customerRepository.deleteCustomer(index);
        }

        private int getCustomerIndex(String id) {
            for(Customer customer: customerRepository.getAllCustomers()) {
                if(customer.getId().equals(id)){
                    return customerRepository.getAllCustomers().indexOf(customer);
                }
            }
            throw new CustomerNotFoundException(id);
        }
}
