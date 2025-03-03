package com.example.simple_expense;

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
public class Expense {
    private final String id = UUID.randomUUID().toString();
    private String description;
    private double amount;
    private String category;
}
