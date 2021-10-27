package com.example.smartbudget.DAO;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;

import java.util.List;

public interface CategoryDao {
    void create(Category category, Budget budget);
    void update(Category category, Budget budget);
    void delete(Category category);
    Category getCategory(Category category);
    List<Category> getCategories(Budget budget);
}
