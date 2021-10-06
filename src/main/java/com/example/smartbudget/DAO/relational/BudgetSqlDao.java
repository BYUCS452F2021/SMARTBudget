package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.BudgetDao;

public class BudgetSqlDao extends SqlDao implements BudgetDao {
    public BudgetSqlDao(SqlStatementExecutor executor) {
        super(executor);
    }

    @Override
    public String getTableStatement() {
        return "TEXT filler";
    }

    @Override
    protected String getTableName() {
        return "budget";
    }
}
