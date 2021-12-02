package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.DeleteBudgetRequest;
import com.example.smartbudget.Response.DeleteBudgetResponse;

public class DeleteBudgetHandler extends Handler<DeleteBudgetRequest, DeleteBudgetResponse> {
    @Override
    protected DeleteBudgetResponse handle(DeleteBudgetRequest request) {
        DatabaseSqlManager.getInstance().createBudgetDao().delete(request.getBudget());
        return new DeleteBudgetResponse();
    }

    @Override
    protected DeleteBudgetResponse fail(Exception e) {
        return new DeleteBudgetResponse(e.getMessage());
    }
}
