package com.example.smartbudget.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Budget {
    private String budgetID;
    String name;
    private double spendingGoal;
    private List<Expenditure> expenditures;
    private List<Category> categories;

    public Budget() {
    }

    public Budget(String name, double spendingGoal) {
        this.name = name;
        this.spendingGoal = spendingGoal;
        this.budgetID = UUID.randomUUID().toString();
        this.expenditures = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getSpendingGoal() {
        return spendingGoal;
    }
}
