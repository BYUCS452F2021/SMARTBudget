package com.example.smartbudget.DAO.relational;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.smartbudget.DAO.StatementExecutor;
import com.example.smartbudget.Exceptions.DataAccessException;

import java.sql.ResultSet;

public class SqlStatementExecutor implements StatementExecutor {
    private SQLiteDatabase db;

    public SqlStatementExecutor(SQLiteDatabase db) {
        this.db = db;
    }

    @Override
    public int executeStatement(String sqlStatement) {
        try {
            db.execSQL(sqlStatement);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public Object executeQuery(String sqlStatement) {
        try {
            return db.rawQuery(sqlStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
