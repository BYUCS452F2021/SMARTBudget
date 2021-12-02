package com.example.smartbudget.Response;

import com.example.smartbudget.Model.Budget;

public class UpdateBudgetResponse extends Response{
    private Budget updatedBudget;

    public UpdateBudgetResponse() {
    }

    public UpdateBudgetResponse(String message) {
        super(message);
    }

    public UpdateBudgetResponse(Budget budget) {
        super();
        this.updatedBudget = budget;
    }

    public Budget getUpdatedBudget() {
        return updatedBudget;
    }
}
