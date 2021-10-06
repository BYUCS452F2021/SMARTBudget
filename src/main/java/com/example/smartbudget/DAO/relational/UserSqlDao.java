package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.UserDao;

public class UserSqlDao extends SqlDao implements UserDao {

    public UserSqlDao(SqlStatementExecutor executor) {
        super(executor);
    }

    @Override
    public String getTableStatement() {
        return "TEXT filler";
    }

    @Override
    protected String getTableName() {
        return "user";
    }
}
