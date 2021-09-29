package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.BudgetDao;

public class BudgetSqlDao extends SqlDao implements BudgetDao {
    public BudgetSqlDao(DatabaseSqlManager manager) {
        super(manager);
    }

    @Override
    public String createTableStatement() {
        return "TEXT filler";
    }

    @Override
    protected String getTableName() {
        return "budget";
    }
}
