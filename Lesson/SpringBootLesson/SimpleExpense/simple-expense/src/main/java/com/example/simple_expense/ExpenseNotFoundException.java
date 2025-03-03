package com.example.simple_expense;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(String id) {
        super("Could not find customer with id: " + id);
      }
}
