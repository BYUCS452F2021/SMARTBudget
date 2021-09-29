package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.CategoryDao;

public class CategorySqlDao extends SqlDao implements CategoryDao {
    public CategorySqlDao(DatabaseSqlManager manager) {
        super(manager);
    }

    @Override
    public String createTableStatement() {
        return "TEXT filler";
    }

    @Override
    protected String getTableName() {
        return "category";
    }
}
