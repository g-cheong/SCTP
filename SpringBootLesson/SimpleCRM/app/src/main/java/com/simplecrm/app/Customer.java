package com.simplecrm.app;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private final String id = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String jobTitle;
    private int yearOfBirth;
}
