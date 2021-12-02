package com.example.smartbudget.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Budget {
    private UUID budgetID;
    private String name;
    private String timestamp;
    private List<Expenditure> expenditures;
    private List<Category> categories;

    public Budget() {
    }

    /**
     * Constructor used when you query a budget from the database
     * @param name
     * @param id
     * @param timestamp
     */
    public Budget(UUID id, String name, LocalDateTime timestamp) {
        this.name = name;
        this.budgetID = id;
        this.timestamp = timestamp.toString();
        this.expenditures = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    /**
     * Constructor used when you create a new budget within the app
     * @param name
     */
    public Budget(String name) {
        this(UUID.randomUUID(), name, LocalDateTime.now());
    }

    public UUID getBudgetID() {
        return budgetID;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTimestamp() {
        return LocalDateTime.parse(timestamp);
    }

    public double calcSpendingGoal(){
        double total = 0;
        for (Category c : categories){
            total += c.getAllotment();
        }
        return total;
    }
}
