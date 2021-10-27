package com.example.smartbudget.DAO.relational;

import android.database.Cursor;

import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.StatementExecutor;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategorySqlDao extends SqlDao implements CategoryDao {
    public CategorySqlDao(StatementExecutor executor) {
        super(executor);
    }

    @Override
    public String getTableStatement() {
        return "category_id TEXT PRIMARY KEY, " +
                "category_name TEXT, " +
                "allotment INTEGER, " +
                "budget_id TEXT, " +
                "FOREIGN KEY(budget_id) REFERENCES budget(budget_id)";
    }

    @Override
    protected String getTableName() {
        return "category";
    }

    public void create(Category category, Budget budget) {
        String sql = "INSERT INTO " + getTableName() + " (category_id, category_name, allotment, budget_id) " +
                " VALUES ('" + category.getId() + "', '" + category.getName() + "', '" +
                category.getAllotment() + "', '" + budget.getBudgetID() + "');";
        try {
            insert(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    public void update(Category category, Budget budget) {
        String sql = "UPDATE " + getTableName() + " SET category_name = '" + category.getName() +
                "', allotment = " + category.getAllotment() + "' WHERE category_id = '" + category.getId() + "';";
        try {
            update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(Category category) {
        String sql = "DELETE FROM " + getTableName() + " WHERE category_id = '" + category.getId() + "';";
        try {
            delete(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Category getCategory(Category category) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE category_id=\'" + category.getId() + "\'";
        Cursor cursor = (Cursor) executor.executeQuery(sql);
        cursor.moveToNext();
        String id = cursor.getString(0);
        String name = cursor.getString(1);
        float allotment = cursor.getFloat(2);
        return new Category(UUID.fromString(id), name, allotment);
    }
    public List<Category> getCategories(Budget budget) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE budget_id='" + budget.getBudgetID() + "';";
        List<Category> categories = new ArrayList<>();
        Cursor result = (Cursor) executor.executeQuery(sql);
        while (result.moveToNext()) {
            categories.add(new Category(UUID.fromString(result.getString(0)),
                    result.getString(1),
                    result.getFloat(2)));
        }
        return categories;
    }
}
