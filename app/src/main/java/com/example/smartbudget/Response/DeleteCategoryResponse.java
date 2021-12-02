package com.example.smartbudget.Response;

import com.example.smartbudget.Model.Category;

public class DeleteCategoryResponse extends Response {
    Category category;

    public DeleteCategoryResponse() {
    }

    public DeleteCategoryResponse(String message) {
        super(message);
    }

    public DeleteCategoryResponse(Category category) {
        super();
        this.category = category;
    }
}
