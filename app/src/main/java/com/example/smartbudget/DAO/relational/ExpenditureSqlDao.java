package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.DAO;
import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.Expenditure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExpenditureSqlDao extends DAO implements ExpenditureDao {

    public ExpenditureSqlDao(Connection conn) {
        super(conn);
    }

    @Override
    public String createTableStatement() {
        return null;
    }

    @Override
    protected String getTableName() {
        return "expenditure";
    }
}
