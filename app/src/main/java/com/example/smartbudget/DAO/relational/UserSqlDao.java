package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.DAO;
import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserSqlDao extends DAO implements UserDao {

    public UserSqlDao(Connection conn) {
        super(conn);
    }

    @Override
    public String createTableStatement() {
        return null;
    }

    @Override
    protected String getTableName() {
        return "user";
    }
}
