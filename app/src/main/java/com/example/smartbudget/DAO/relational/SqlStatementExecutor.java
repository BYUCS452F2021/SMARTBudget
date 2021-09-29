package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.Exceptions.DataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlStatementExecutor {
    private SqlDatabase db;

    public SqlStatementExecutor(String path) {
        db = new SqlDatabase(path);
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
}
