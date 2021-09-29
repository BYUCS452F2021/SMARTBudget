package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.BudgetDao;
import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.DaoFactory;
import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.DAO.UserDao;

import java.sql.Connection;

public class SqlDaoFactory implements DaoFactory {
    private DatabaseSqlManager db;

    public SqlDaoFactory(DatabaseSqlManager db) {
        this.db = db;
    }

    @Override
    public UserSqlDao createUserDao() {
        return new UserSqlDao(db);
    }

    @Override
    public BudgetSqlDao createBudgetDao() {
        return new BudgetSqlDao(db);
    }

    @Override
    public CategorySqlDao createCategoryDao() {
        return new CategorySqlDao(db);
    }

    @Override
    public ExpenditureSqlDao createExpenditureDao() {
        return new ExpenditureSqlDao(db);
    }
}
