package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.GetBudgetsRequest;
import com.example.smartbudget.Response.GetBudgetResponse;

public class GetBudgetsHandler {
    public GetBudgetResponse getBudgets(GetBudgetsRequest request){
        try {
            return new GetBudgetResponse(DatabaseSqlManager.getInstance().createBudgetDao().getBudgets(request.getUser()));
        } catch (Exception e) {
            return new GetBudgetResponse(e.getMessage());
        }
    }
}
