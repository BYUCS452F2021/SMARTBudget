package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.AddBudgetRequest;
import com.example.smartbudget.Response.AddBudgetResponse;
import com.example.smartbudget.Response.Response;

public class AddBudgetHandler extends Handler<AddBudgetRequest, AddBudgetResponse> {
    @Override
    public AddBudgetResponse handle(AddBudgetRequest request) {
        DatabaseSqlManager.getInstance().createBudgetDao().insert(request.getBudget(), request.getUser());
        return new AddBudgetResponse(request.getBudget());
    }

    @Override
    protected AddBudgetResponse fail(Exception e) {
        return new AddBudgetResponse(e.getMessage());
    }
}
