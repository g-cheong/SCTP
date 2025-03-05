package com.simplecrm.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class CustomerServiceImpl implements CustomerService {
        private CustomerRepository customerRepository;
        private InteractionRepository interactionRepository;

        public CustomerServiceImpl(CustomerRepository customerRepository, InteractionRepository interactionRepository) {
            this.interactionRepository = interactionRepository; 
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

        // private int getCustomerIndex(String id) {
        //     for(Customer customer: customerRepository.getAllCustomers()) {
        //         if(customer.getId().equals(id)){
        //             return customerRepository.getAllCustomers().indexOf(customer);
        //         }
        //     }
        //     throw new CustomerNotFoundException(id);
        // }

        public Interaction createInteractionToCustomer(Long id, Interaction interaction) {
            Customer selectedCustomer = customerRepository.findById(id).get();
            interaction.setCustomer(selectedCustomer);
            return interactionRepository.save(interaction);
        }
}
