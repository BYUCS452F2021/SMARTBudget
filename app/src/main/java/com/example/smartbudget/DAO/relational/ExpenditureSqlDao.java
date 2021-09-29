package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.ExpenditureDao;

public class ExpenditureSqlDao extends SqlDao implements ExpenditureDao {

    public ExpenditureSqlDao(SqlStatementExecutor executor) {
        super(executor);
    }

    @Override
    public String getTableStatement() {
        return "TEXT filler";
    }

    @Override
    protected String getTableName() {
        return "expenditure";
    }
}
