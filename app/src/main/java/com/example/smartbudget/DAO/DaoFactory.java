package com.example.smartbudget.DAO;

import java.sql.Connection;

public interface DaoFactory {
    UserDao createUserDao();
    BudgetDao createBudgetDao();
    CategoryDao createCategoryDao();
    ExpenditureDao createExpenditureDao();
}
