package com.simplecrm.app;

import java.util.ArrayList;
import java.util.List;

// import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceWithLoggingImpl implements CustomerService {
        // private final Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerServiceWithLoggingImpl.class);  
        private CustomerRepository customerRepository;

        public CustomerServiceWithLoggingImpl(CustomerRepository customerRepository) { 
            this.customerRepository = customerRepository;
        }    

        public Customer createCustomer(Customer customer) {
            // return customerRepository.createCustomer(customer);
            return customerRepository.save(customer);
        }

        public Customer getCustomer(Long id) {
            // int index = getCustomerIndex(id);
            // return customerRepository.getCustomer(index);
            Customer foundCustomer = customerRepository.findById(id).get();
            return foundCustomer;
        }

        public ArrayList<Customer> getAllCustomers() {
            // return customerRepository.getAllCustomers();
            List<Customer> allCustomers = customerRepository.findAll();
            return (ArrayList<Customer>) allCustomers; 
        }

        public Customer updateCustomer(Long id, Customer customer) {
            // int index = getCustomerIndex(id);
            // return customerRepository.updateCustomer(index, customer);
            Customer customerToUpdate = customerRepository.findById(id).get();
            customerToUpdate.setFirstName(customer.getFirstName());
            customerToUpdate.setLastName(customer.getLastName());
            customerToUpdate.setEmail(customer.getEmail());
            customerToUpdate.setJobTitle(customer.getJobTitle());
            customerToUpdate.setContactNo(customer.getContactNo());
            customerToUpdate.setYearOfBirth(customer.getYearOfBirth());; 
            Customer savedCustomer = customerRepository.save(customerToUpdate);
            return savedCustomer;
        }

        public void deleteCustomer(Long id) {
            // int index = getCustomerIndex(id);
            // customerRepository.deleteCustomer(index);
            customerRepository.deleteById(id);
        }

        @Override
        public Interaction createInteractionToCustomer(Long id, Interaction interaction) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'createInteractionToCustomer'");
        }

        // private int getCustomerIndex(String id) {
        //     for(Customer customer: customerRepository.getAllCustomers()) {
        //         if(customer.getId().equals(id)){
        //             return customerRepository.getAllCustomers().indexOf(customer);
        //         }
        //     }
        //     throw new CustomerNotFoundException(id);
        // }
}
