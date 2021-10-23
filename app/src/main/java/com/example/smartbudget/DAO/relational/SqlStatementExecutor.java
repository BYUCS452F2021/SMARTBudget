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
    public void executeStatement(String sqlStatement) {
        db.execSQL(sqlStatement);
    }

    @Override
    public Object executeQuery(String sqlStatement) {
        return db.rawQuery(sqlStatement, null);
    }
}
