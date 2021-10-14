package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.BudgetDao;
import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.DaoFactory;
import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.Exceptions.DataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSqlManager implements DaoFactory {
    private static DatabaseSqlManager _instance;
    private List<SqlDao> databaseDAOs;
    private SqlDaoFactory factory;

    // Constructor take in path of database to connect to and need to decide how factory sets up DAOs
    // Create tables in constructor?


    private DatabaseSqlManager(String path) throws DataAccessException{
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
        _instance = new DatabaseSqlManager(dbPath);
    }

    public static DatabaseSqlManager getInstance() {
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

