package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.DeleteBudgetRequest;
import com.example.smartbudget.Response.DeleteBudgetResponse;

public class DeleteBudgetHandler {
    public DeleteBudgetResponse deleteBudget(DeleteBudgetRequest request){
        try {
            DatabaseSqlManager.getInstance().createBudgetDao().delete(request.getBudget());
            return new DeleteBudgetResponse();
        } catch (Exception e) {
            return new DeleteBudgetResponse(e.getMessage());
        }
    }
}
