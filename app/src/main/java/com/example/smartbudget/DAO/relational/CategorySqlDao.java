package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.DAO;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CategorySqlDao extends DAO implements CategoryDao {
    public CategorySqlDao(Connection conn) {
        super(conn);
    }

    @Override
    public String createTableStatement() {
        return null;
    }

    @Override
    protected String getTableName() {
        return "category";
    }
}
