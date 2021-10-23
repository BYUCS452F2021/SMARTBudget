package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.AddBudgetRequest;
import com.example.smartbudget.Response.AddBudgetResponse;

public class AddBudgetHandler {
    public AddBudgetResponse addBudget(AddBudgetRequest request){
        try {
            DatabaseSqlManager.getInstance().createBudgetDao().insert(request.getBudget(), request.getUser());
            return new AddBudgetResponse(request.getBudget());
        } catch (Exception e) {
            return new AddBudgetResponse(e.getMessage());
        }
    }
}
