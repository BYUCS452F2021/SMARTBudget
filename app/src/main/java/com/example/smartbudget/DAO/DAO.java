package com.example.smartbudget.DAO;

import com.example.smartbudget.Exceptions.DataAccessException;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAO {

    protected Connection conn;

    public DAO(Connection conn) {
        this.conn = conn;
    }

    abstract public String createTableStatement();
    public void createTable() throws DataAccessException{
        executeStatement(createTableStatement());
    }

    abstract protected String getTableName();

    public void clearTable() throws DataAccessException {
        executeStatement("DELETE FROM " + getTableName());
    }

    public void dropTable() throws DataAccessException {
        executeStatement("DROP TABLE " + getTableName());
    }

    public int insert(String schema, String values) throws DataAccessException{
        String sql = "INSERT INTO " + getTableName() + " (" + schema + ") values (" + values + ");";
        try {
            return conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    private void executeStatement(String sqlStatement) throws DataAccessException{
        try {
            conn.createStatement().executeUpdate(sqlStatement);
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
    }
}
