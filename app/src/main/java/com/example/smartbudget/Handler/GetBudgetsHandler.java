package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.GetBudgetsRequest;
import com.example.smartbudget.Response.GetBudgetResponse;

public class GetBudgetsHandler extends Handler<GetBudgetsRequest, GetBudgetResponse> {
    @Override
    protected GetBudgetResponse handle(GetBudgetsRequest request) {
        return new GetBudgetResponse(DatabaseSqlManager.getInstance().createBudgetDao().getBudgets(request.getUser()));
    }

    @Override
    protected GetBudgetResponse fail(Exception e) {
        return new GetBudgetResponse(e.getMessage());
    }
}
