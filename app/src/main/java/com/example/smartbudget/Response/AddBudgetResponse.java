package com.example.smartbudget.Response;

import com.example.smartbudget.Model.Budget;

public class AddBudgetResponse extends Response{
    private Budget budget;

    public AddBudgetResponse(){}

    public AddBudgetResponse(String message) {
        super(message);
    }

    public AddBudgetResponse(Budget budget) {
        super();
        this.budget = budget;
    }

    public Budget getBudget() {
        return budget;
    }
}
