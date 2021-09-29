package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.ExpenditureDao;

public class ExpenditureSqlDao extends SqlDao implements ExpenditureDao {

    public ExpenditureSqlDao(DatabaseSqlManager manager) {
        super(manager);
    }

    @Override
    public String createTableStatement() {
        return "TEXT filler";
    }

    @Override
    protected String getTableName() {
        return "expenditure";
    }
}
