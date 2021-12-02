package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.DataCache;
import com.example.smartbudget.Request.GetExpendituresForDayRequest;
import com.example.smartbudget.Response.GetExpenditureForDayResponse;

public class GetExpendituresForDayHandler extends Handler<GetExpendituresForDayRequest, GetExpenditureForDayResponse> {
    @Override
    protected GetExpenditureForDayResponse handle(GetExpendituresForDayRequest request) {
        return new GetExpenditureForDayResponse(DatabaseSqlManager
                .getInstance()
                .createExpenditureDao()
                .getExpendituresForDay(
                        request.getBudget(),
                        request.getYear(),
                        request.getMonth(),
                        request.getDay()
                ));
    }

    @Override
    protected GetExpenditureForDayResponse fail(Exception e) {
        return new GetExpenditureForDayResponse(e.getMessage());
    }
}
