package com.example.smartbudget.DAO;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;

public interface CategoryDao {
    void createCategory(Category category, Budget budget);
    void updateCategory(Category category, Budget budget);
    void deleteCategory(String id);
    Category getCategory(String category_id);
}
