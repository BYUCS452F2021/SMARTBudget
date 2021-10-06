package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.BudgetDao;
import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.DaoFactory;
import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.DAO.UserDao;

public class SqlDaoFactory implements DaoFactory {
    private SqlStatementExecutor executor;

    public SqlDaoFactory(String path) {
        executor = new SqlStatementExecutor(path);
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
