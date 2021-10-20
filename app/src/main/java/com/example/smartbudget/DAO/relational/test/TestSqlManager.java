package com.example.smartbudget.DAO.relational.test;

import com.example.smartbudget.DAO.BudgetDao;
import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.DaoFactory;
import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.DAO.relational.BudgetSqlDao;
import com.example.smartbudget.DAO.relational.CategorySqlDao;
import com.example.smartbudget.DAO.relational.ExpenditureSqlDao;
import com.example.smartbudget.DAO.relational.SqlDao;
import com.example.smartbudget.DAO.relational.SqlDaoFactory;
import com.example.smartbudget.DAO.relational.UserSqlDao;
import com.example.smartbudget.Exceptions.DataAccessException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * This class should only be used for testing and absolutely nothing else.
 *
 *
 *
 * DO NOT USE THIS CLASS IN THE APP, IT WILL NOT WORK
 *
 *
 *
 *
 *
 * Thanks
 *
 *
 *
 *
 */

public class TestSqlManager implements DaoFactory {
    private static TestSqlManager _instance;
    private List<SqlDao> databaseDAOs;
    private SqlDaoFactory factory;

    // Constructor take in path of database to connect to and need to decide how factory sets up DAOs
    // Create tables in constructor?


    private TestSqlManager(String path) throws DataAccessException {
        factory = new SqlDaoFactory(path);
        databaseDAOs = new ArrayList<>();
        databaseDAOs.add((UserSqlDao) factory.createUserDao());
        databaseDAOs.add((BudgetSqlDao) factory.createBudgetDao());
        databaseDAOs.add((CategorySqlDao) factory.createCategoryDao());
        databaseDAOs.add((ExpenditureSqlDao) factory.createExpenditureDao());
        createTables();
    }

    private static void init() throws DataAccessException {
        init("db.sqlite");
    }

    // Testing only, DO NOT USE IN ANY CODE YOU FIEND
    public static void init(String dbPath) throws DataAccessException {
        _instance = new TestSqlManager(dbPath);
    }

    public static TestSqlManager getInstance() {
        if (_instance == null){
            try {
                init();
            } catch (DataAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
        return _instance;
    }

    public void clearTables() throws DataAccessException {
        for (SqlDao dao : databaseDAOs){
            dao.clearTable();
        }
    }

    private void createTables() throws DataAccessException{
        for (SqlDao dao : databaseDAOs){
            dao.createTable();
        }
    }

    public void dropTables() throws DataAccessException {
        for (SqlDao dao : databaseDAOs){
            dao.dropTable();
        }
    }

    @Override
    public UserDao createUserDao() {
        return factory.createUserDao();
    }

    @Override
    public BudgetDao createBudgetDao() {
        return factory.createBudgetDao();
    }

    @Override
    public CategoryDao createCategoryDao() {
        return factory.createCategoryDao();
    }

    @Override
    public ExpenditureDao createExpenditureDao() {
        return factory.createExpenditureDao();
    }
}
