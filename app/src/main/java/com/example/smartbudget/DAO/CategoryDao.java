package com.example.smartbudget.DAO;

import com.example.smartbudget.Model.Category;

public interface CategoryDao {
    void createCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(String id);
    Category getCategory(String category_id);
}
