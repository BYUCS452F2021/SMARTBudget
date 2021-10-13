package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.CategoryDao;

public class CategorySqlDao extends SqlDao implements CategoryDao {
    public CategorySqlDao(SqlStatementExecutor executor) {
        super(executor);
    }

    @Override
    public String getTableStatement() {
        return "category_id TEXT PRIMARY KEY, " +
                "name TEXT, " +
                "spending_goal INTEGER, " +
                "budget_id TEXT, " +
                "FOREIGN KEY(budget_id) REFERENCES budget(budget_id)";
    }

    @Override
    protected String getTableName() {
        return "category";
    }
}
