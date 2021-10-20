package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.StatementExecutor;

public class CategorySqlDao extends SqlDao implements CategoryDao {
    public CategorySqlDao(StatementExecutor executor) {
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
