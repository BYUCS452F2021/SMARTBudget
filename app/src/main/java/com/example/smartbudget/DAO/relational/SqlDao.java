package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.StatementExecutor;
import com.example.smartbudget.Exceptions.DataAccessException;

import java.sql.ResultSet;

public abstract class SqlDao {

    protected StatementExecutor executor;

    public SqlDao(StatementExecutor executor) {
        this.executor = executor;
    }

    abstract public String getTableStatement();

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " + getTableName() + "(" +
                getTableStatement() +
                ");";
        executor.executeStatement(sql);
    }

    abstract protected String getTableName();

    public void clearTable() {
        executor.executeStatement("DELETE FROM " + getTableName());
    }

    public void dropTable() {
        executor.executeStatement("DROP TABLE " + getTableName());
    }

    public int insert(String sqlInsertStatement) throws DataAccessException{
        // String sql = "INSERT INTO " + getTableName() + " (" + schema + ") values (" + values + ");";
        return executor.executeStatement(sqlInsertStatement);
    }

    public Object read(String sqlSelectStatement) {
        return executor.executeQuery(sqlSelectStatement);
    }

    public int update(String sqlUpdateStatement) throws DataAccessException{
        //update person set username = 'john123', gender = 'm' where firstName = 'john'
        // String sql = "UPDATE " + getTableName() + " SET " + " ";
        return executor.executeStatement(sqlUpdateStatement);
    }

    public int delete(String sqlDeleteStatement) throws DataAccessException {
        return executor.executeStatement(sqlDeleteStatement);
    }
}
