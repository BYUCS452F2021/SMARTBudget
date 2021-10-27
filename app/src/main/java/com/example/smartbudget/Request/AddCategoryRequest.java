package com.example.smartbudget.Request;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;

public class AddCategoryRequest {
    private Budget budget;
    private Category category;

    public AddCategoryRequest(Category category, Budget budget) {
        this.budget = budget;
        this.category = category;
    }

    public Budget getBudget() {
        return budget;
    }

    public Category getCategory() {
        return category;
    }
}
