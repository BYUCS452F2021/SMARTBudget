package com.example.smartbudget.Request;

import com.example.smartbudget.Model.Budget;

import java.util.UUID;

public class DeleteBudgetRequest {
    private Budget budget;

    public DeleteBudgetRequest(Budget budget) {
        this.budget = budget;
    }

    public Budget getBudget() {
        return budget;
    }
}
