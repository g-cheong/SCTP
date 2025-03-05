package com.simplecrm.app;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
    private final CustomerRepository customerRepository;

    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void loadData() {
        customerRepository.deleteAll();
    
        customerRepository.save(Customer.builder().firstName("Bruce").lastName("Banner").email("hulksmash@banner.com").build());        
        customerRepository.save(Customer.builder().firstName("Peter").lastName("Parker").email("thefriendlyneighbourhood@spiderman.com").build());        
        customerRepository.save(Customer.builder().firstName("Thor").lastName("Odison").email("thorlovesJaneFoster@asgard.com").build());     
    }
}
