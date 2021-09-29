package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.UserDao;

public class UserSqlDao extends SqlDao implements UserDao {

    public UserSqlDao(DatabaseSqlManager manager) {
        super(manager);
    }

    @Override
    public String createTableStatement() {
        return "TEXT filler";
    }

    @Override
    protected String getTableName() {
        return "user";
    }
}
