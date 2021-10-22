package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.DAO.StatementExecutor;

public class ExpenditureSqlDao extends SqlDao implements ExpenditureDao {

    public ExpenditureSqlDao(StatementExecutor executor) {
        super(executor);
    }

    //Expenditure(ExpenditureID, CategoryID, ExpenditureDescription, ExpenditureAmount,
    // ExpenditureYear, ExpenditureMonth, ExpenditureDay)
    //Foreign Key CategoryID references Category

    @Override
    public String getTableStatement() {
        return "TEXT filler";
    }

    @Override
    protected String getTableName() {
        return "expenditure";
    }
}
