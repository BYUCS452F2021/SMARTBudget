package com.example.smartbudget.Request;

import com.example.smartbudget.Model.Category;

public class DeleteCategoryRequest {
    private Category category;

    public DeleteCategoryRequest(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
