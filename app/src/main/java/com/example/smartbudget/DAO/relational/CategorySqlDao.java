package com.example.smartbudget.DAO.relational;

import android.database.Cursor;

import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.StatementExecutor;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Model.User;

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

    public void createCategory(Category category) {
        String sql = "INSERT INTO " + getTableName() + " (category_id, category_name, allotment) " +
                " VALUES ('" + category.getId() + "', '" + category.getName() + "', '" +
                category.getAllotment() + "');";
        try {
            insert(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    public void updateCategory(Category category) {

    }
    public void deleteCategory(String id) {

    }
    public Category getCategory(String category_id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE category_id=\'" + category_id + "\'";
        Cursor cursor = (Cursor) executor.executeQuery(sql);
        cursor.moveToNext();
        String id = cursor.getString(0);
        String name = cursor.getString(1);
        float allotment = cursor.getFloat(2);
        return new Category(UUID.fromString(id), name, allotment);
    }
}
