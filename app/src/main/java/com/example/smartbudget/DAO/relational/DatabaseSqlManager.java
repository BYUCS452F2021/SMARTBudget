package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.Exceptions.DataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSqlManager {
    private SqlDatabase db;
    private List<SqlDao> databaseDAOs;

    // Constructor take in path of database to connect to and need to decide how factory sets up DAOs
    // Create tables in constructor?
    public DatabaseSqlManager(String path) throws DataAccessException{
        this.db = new SqlDatabase(path);
        SqlDaoFactory factory = new SqlDaoFactory(this);
        databaseDAOs = new ArrayList<>();
        databaseDAOs.add(factory.createUserDao());
        databaseDAOs.add(factory.createBudgetDao());
        databaseDAOs.add(factory.createCategoryDao());
        databaseDAOs.add(factory.createExpenditureDao());
        createTables();
    }


    public int executeStatement(String sqlStatement) throws DataAccessException {
        int result = 0;
        try {
            result = db.getConnection().createStatement().executeUpdate(sqlStatement);
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
        finally {
            db.closeConnection(true);
        }
        return result;
    }

    public ResultSet executeQuery (String sqlStatement) throws DataAccessException {
        ResultSet result = null;
        try {
            result = db.getConnection().createStatement().executeQuery(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            db.closeConnection(false);
        }
        return result;
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

