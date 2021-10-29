package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.UpdateBudgetRequest;
import com.example.smartbudget.Response.UpdateBudgetResponse;

public class UpdateBudgetHandler {
    public UpdateBudgetResponse updateBudget(UpdateBudgetRequest request){
        try {
            DatabaseSqlManager.getInstance().createBudgetDao().update(request.getBudget(), request.getUser());
            return new UpdateBudgetResponse(request.getBudget());
        } catch (Exception e) {
            return new UpdateBudgetResponse(e.getMessage());
        }
    }
}
