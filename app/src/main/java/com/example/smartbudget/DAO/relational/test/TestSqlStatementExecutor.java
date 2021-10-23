package com.example.smartbudget.DAO.relational.test;

import android.database.SQLException;

import com.example.smartbudget.DAO.StatementExecutor;
import com.example.smartbudget.DAO.relational.SqlDatabase;
import com.example.smartbudget.Exceptions.DataAccessException;

import java.sql.ResultSet;

public class TestSqlStatementExecutor implements StatementExecutor {
    private SqlDatabase db;

    public TestSqlStatementExecutor(String dbPath) {
        this.db = new SqlDatabase(dbPath);
    }

    @Override
    public void executeStatement(String sqlStatement) {
        try {
            db.getConnection().createStatement().executeUpdate(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            db.closeConnection(true);
        }
    }

    @Override
    public Object executeQuery(String sqlStatement) {
        ResultSet result = null;
        try {
            result = db.getConnection().createStatement().executeQuery(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            db.closeConnection(false);
        }
        return result;
    }
}
