package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.BudgetDao;
import com.example.smartbudget.DAO.StatementExecutor;

public class BudgetSqlDao extends SqlDao implements BudgetDao {
    public BudgetSqlDao(StatementExecutor executor) {
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
