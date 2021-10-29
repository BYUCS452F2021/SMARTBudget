package com.example.smartbudget.Request;

import com.example.smartbudget.Model.Budget;

public class GetCategoriesRequest {
    Budget budget;

    public GetCategoriesRequest(Budget budget) {
        this.budget = budget;
    }

    public Budget getBudget() {
        return budget;
    }
}
