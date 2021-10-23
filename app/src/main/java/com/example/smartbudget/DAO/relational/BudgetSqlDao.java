package com.example.smartbudget.DAO.relational;

import android.database.Cursor;

import com.example.smartbudget.DAO.BudgetDao;
import com.example.smartbudget.DAO.StatementExecutor;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BudgetSqlDao extends SqlDao implements BudgetDao {
    public BudgetSqlDao(StatementExecutor executor) {
        super(executor);
    }

    @Override
    public String getTableStatement() {
        return "budget_id TEXT PRIMARY KEY, " +
                "budget_name TEXT NOT NULL, " +
                "timestamp TEXT NOT NULL, " +
                "user_id TEXT NOT NULL, " +
                "FOREIGN KEY(user_id) REFERENCES user(user_id)";
    }

    @Override
    protected String getTableName() {
        return "budget";
    }


    @Override
    public void insert(Budget budget, User user) {
        //insert into user (user_id, user_name, user_password) values ('','','',);
        String sql = "INSERT INTO " + getTableName() + " (budget_id, user_id, budget_name, " +
                "timestamp)" +
                " VALUES ('" + budget.getBudgetID() + "','" + user.getId() + "','" +
                budget.getName() + "','" + budget.getTimestamp().toString() + "');";
        try {
            insert(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Budget> getBudgets(User user) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE user_id='" + user.getId() + "';";
        List<Budget> budgets = new ArrayList<>();
        Cursor result = (Cursor) executor.executeQuery(sql);
        while (result.moveToNext()){
            budgets.add(new Budget(
                    UUID.fromString(result.getString(0)),
                    result.getString(1),
                    LocalDateTime.parse(result.getString(2))
            ));
        }
        return budgets;
    }
}
