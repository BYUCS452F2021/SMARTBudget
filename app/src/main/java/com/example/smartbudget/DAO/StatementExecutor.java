package com.example.smartbudget.DAO;

public interface StatementExecutor {
    int executeStatement(String sqlStatement);
    Object executeQuery(String sqlStatement);
}
