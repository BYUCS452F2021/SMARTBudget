package com.example.smartbudget.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Budget {
    private String budgetID;
    private double spendingGoal;
    private List<Expenditure> expenditures;
    private List<Category> categories;

    public Budget() {
    }

    public Budget(double spendingGoal) {
        this.spendingGoal = spendingGoal;
        this.budgetID = UUID.randomUUID().toString();
        this.expenditures = new ArrayList<>();
        this.categories = new ArrayList<>();
    }
}
