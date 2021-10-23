package com.example.smartbudget.DAO;

import com.example.smartbudget.DAO.relational.SqlDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.User;

import java.util.List;


public interface BudgetDao {
    void insert(Budget budget, User user);
    List<Budget> getBudgets(User user);
}
