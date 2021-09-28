package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.BudgetDao;
import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.DaoFactory;
import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.DAO.UserDao;

import java.sql.Connection;

public class SqlDaoFactory implements DaoFactory {
    private Connection connection;

    public SqlDaoFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public UserDao createUserDao() {
        return new UserSqlDao(connection);
    }

    @Override
    public BudgetDao createBudgetDao() {
        return new BudgetSqlDao(connection);
    }

    @Override
    public CategoryDao createCategoryDao() {
        return new CategorySqlDao(connection);
    }

    @Override
    public ExpenditureDao createExpenditureDao() {
        return new ExpenditureSqlDao(connection);
    }
}
