package com.example.smartbudget.Request;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.User;

public class AddBudgetRequest {
    private Budget budget;
    private User user;

    public AddBudgetRequest(Budget budget, User user) {
        this.budget = budget;
        this.user = user;
    }

    public Budget getBudget() {
        return budget;
    }

    public User getUser() {
        return user;
    }
}
