package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.Exceptions.DataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSqlManager {
    private List<SqlDao> databaseDAOs;

    // Constructor take in path of database to connect to and need to decide how factory sets up DAOs
    // Create tables in constructor?
    public DatabaseSqlManager(String path) throws DataAccessException{
        SqlDaoFactory factory = new SqlDaoFactory(path);
        databaseDAOs = new ArrayList<>();
        databaseDAOs.add((UserSqlDao) factory.createUserDao());
        databaseDAOs.add((BudgetSqlDao) factory.createBudgetDao());
        databaseDAOs.add((CategorySqlDao) factory.createCategoryDao());
        databaseDAOs.add((ExpenditureSqlDao) factory.createExpenditureDao());
        createTables();
    }

    public void clearTables() throws DataAccessException {
        for (SqlDao dao : databaseDAOs){
            dao.clearTable();
        }
    }

    private void createTables() throws DataAccessException{
        for (SqlDao dao : databaseDAOs){
            dao.createTable();
        }
    }

    public void dropTables() throws DataAccessException {
        for (SqlDao dao : databaseDAOs){
            dao.dropTable();
        }
    }
}

