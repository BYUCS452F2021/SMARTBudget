package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.BudgetDao;
import com.example.smartbudget.DAO.DAO;
import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.Exceptions.BadLoginException;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Request.CreateBudgetRequest;
import com.example.smartbudget.Request.ReadBudgetRequest;
import com.example.smartbudget.Response.CreateBudgetResponse;
import com.example.smartbudget.Response.ReadBudgetResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class BudgetSqlDao extends DAO implements BudgetDao {
    public BudgetSqlDao(Connection conn) {
        super(conn);
    }

    @Override
    public String createTableStatement() {
        return null;
    }

    @Override
    protected String getTableName() {
        return "budget";
    }
}
