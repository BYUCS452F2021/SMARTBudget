package com.example.smartbudget.Response;

import com.example.smartbudget.Model.Budget;

import java.util.List;

public class GetBudgetResponse extends Response{
    private List<Budget> budgets;

    public GetBudgetResponse() {
    }

    public GetBudgetResponse(String message) {
        super(message);
    }

    public GetBudgetResponse(List<Budget> budgets) {
        super();
        this.budgets = budgets;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }
}
