package com.example.smartbudget.DAO;

import com.example.smartbudget.Model.Category;

public interface CategoryDao {
    boolean createCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(String id);
    Category getCategory(String category_id);
}
