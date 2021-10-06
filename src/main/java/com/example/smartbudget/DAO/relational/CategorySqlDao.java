package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.CategoryDao;

public class CategorySqlDao extends SqlDao implements CategoryDao {
    public CategorySqlDao(SqlStatementExecutor executor) {
        super(executor);
    }

    @Override
    public String getTableStatement() {
        return "TEXT filler";
    }

    @Override
    protected String getTableName() {
        return "category";
    }
}
