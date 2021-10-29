package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.DataCache;
import com.example.smartbudget.Request.GetExpendituresForDayRequest;
import com.example.smartbudget.Response.GetBudgetResponse;
import com.example.smartbudget.Response.GetExpenditureForDayResponse;

public class GetExpendituresForDayHandler {
    public GetExpenditureForDayResponse getExpenditures(GetExpendituresForDayRequest request){
        try {
            return new GetExpenditureForDayResponse(DatabaseSqlManager.getInstance().createExpenditureDao().getExpendituresForDay(request.getBudget(), DataCache.getInstance().getCurrDate().getYear(), DataCache.getInstance().getCurrDate().getMonthValue(), DataCache.getInstance().getCurrDate().getDayOfMonth()));
        } catch (Exception e) {
            return new GetExpenditureForDayResponse(e.getMessage());
        }
    }
}
