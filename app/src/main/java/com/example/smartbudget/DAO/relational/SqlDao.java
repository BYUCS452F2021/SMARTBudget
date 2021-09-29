package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Exceptions.DataAccessException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class SqlDao {

    protected DatabaseSqlManager manager;

    public SqlDao(DatabaseSqlManager manager) {
        this.manager = manager;
    }

    abstract public String createTableStatement();
    public void createTable() throws DataAccessException{
        String sql = "CREATE TABLE IF NOT EXISTS " + getTableName() + "(" +
                createTableStatement() +
                ");";
        manager.executeStatement(sql);
    }

    abstract protected String getTableName();

    public void clearTable() throws DataAccessException {
        manager.executeStatement("DELETE FROM " + getTableName());
    }

    public void dropTable() throws DataAccessException {
        manager.executeStatement("DROP TABLE " + getTableName());
    }

    public int insert(String sqlInsertStatement) throws DataAccessException{
        // String sql = "INSERT INTO " + getTableName() + " (" + schema + ") values (" + values + ");";
        return manager.executeStatement(sqlInsertStatement);
    }

    public ResultSet read(String sqlSelectStatement) throws DataAccessException {
        return manager.executeQuery(sqlSelectStatement);
    }

    public int update(String sqlUpdateStatement) throws DataAccessException{
        //update person set username = 'john123', gender = 'm' where firstName = 'john'
        // String sql = "UPDATE " + getTableName() + " SET " + " ";
        return manager.executeStatement(sqlUpdateStatement);
    }

    public int delete(String sqlDeleteStatement) throws DataAccessException {
        return manager.executeStatement(sqlDeleteStatement);
    }
}
