package com.simplecrm.app;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceWithLoggingImpl implements CustomerService {
        private final Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerServiceWithLoggingImpl.class);  
        private CustomerRepository customerRepository;

        public CustomerServiceWithLoggingImpl(CustomerRepository customerRepository) { 
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
            logger.info("'🟢 CustomerSerivceWithLoggingImpl.getAllCustomers() called'") ;
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
