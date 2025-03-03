package com.example.simple_expense;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class Controller {
    ArrayList<Expense> expenses = new ArrayList<Expense>();
    public Controller() {
        expenses.add(Expense.builder().description("Oranges").amount(10.99).category("grocery").build());
        expenses.add(Expense.builder().description("Apples").amount(15.99).category("grocery").build());
        expenses.add(Expense.builder().description("Lunch").amount(10.00).category("tech").build());    
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        expenses.add(expense);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense, @PathVariable String id) {
        int index = getExpenseIndex(id);
        expenses.set(index, expense);
        return new ResponseEntity<>(expense, HttpStatus.ACCEPTED);
    }
    @GetMapping
    public ResponseEntity<ArrayList<Expense>> getExpenses(@RequestParam(defaultValue = "") String category, @RequestParam(defaultValue = "") String minAmount, @RequestParam(defaultValue = "") String maxAmount) {
        ArrayList<Expense> filteredExpense = (new ArrayList<>(expenses));
        if(!category.isEmpty()) {
            filteredExpense.removeIf((e -> !e.getCategory().equals(category))); 
        }
        Double min = minAmount.isEmpty() ? null : Double.parseDouble(minAmount);
        Double max = maxAmount.isEmpty() ? null : Double.parseDouble(maxAmount);
    
        filteredExpense.removeIf(e -> (min != null && e.getAmount() < min) || 
                                       (max != null && e.getAmount() > max));

        return new ResponseEntity<>(filteredExpense, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable String id) {
        int index = getExpenseIndex(id);
        Expense expense = expenses.get(index);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }
    private int getExpenseIndex(String id) {
        for(Expense expense: expenses){
            if(expense.getId().equals(id)){
                return expenses.indexOf(expense);
            }
        }
        throw new ExpenseNotFoundException(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ArrayList<Expense>> deletExpense(@PathVariable String id) {
        int index = getExpenseIndex(id);
        expenses.remove(index);
        return new ResponseEntity<>(expenses, HttpStatus.NO_CONTENT);
    }
}
