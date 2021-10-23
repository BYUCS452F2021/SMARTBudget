package com.example.smartbudget.DAO;

public interface StatementExecutor {
    void executeStatement(String sqlStatement);
    Object executeQuery(String sqlStatement);
}
