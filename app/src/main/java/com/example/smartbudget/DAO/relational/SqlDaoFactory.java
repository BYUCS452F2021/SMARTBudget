package com.example.smartbudget.DAO.relational;

import android.database.sqlite.SQLiteDatabase;

import com.example.smartbudget.DAO.BudgetDao;
import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.DaoFactory;
import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.DAO.StatementExecutor;
import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.DAO.relational.test.TestSqlStatementExecutor;

public class SqlDaoFactory implements DaoFactory {
    private StatementExecutor executor;

    public SqlDaoFactory(SQLiteDatabase db) {
        executor = new SqlStatementExecutor(db);
    }

    public SqlDaoFactory(String dbPath) {
        executor = new TestSqlStatementExecutor(dbPath);
    }

    @Override
    public UserDao createUserDao() {
        return new UserSqlDao(executor);
    }

    @Override
    public BudgetDao createBudgetDao() {
        return new BudgetSqlDao(executor);
    }

    @Override
    public CategoryDao createCategoryDao() {
        return new CategorySqlDao(executor);
    }

    @Override
    public ExpenditureDao createExpenditureDao() {
        return new ExpenditureSqlDao(executor);
    }
}
