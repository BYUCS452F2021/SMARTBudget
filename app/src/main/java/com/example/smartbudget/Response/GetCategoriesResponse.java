package com.example.smartbudget.Response;

import com.example.smartbudget.Model.Category;

import java.util.List;

public class GetCategoriesResponse extends Response {
    private List<Category> categories;

    public GetCategoriesResponse() {
    }

    public GetCategoriesResponse(String message) {
        super(message);
    }

    public GetCategoriesResponse(List<Category> categories) {
        super();
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
