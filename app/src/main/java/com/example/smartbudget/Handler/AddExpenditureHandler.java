package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.AddExpenditureRequest;
import com.example.smartbudget.Response.AddExpenditureResponse;

public class AddExpenditureHandler extends Handler<AddExpenditureRequest, AddExpenditureResponse> {
    @Override
    protected AddExpenditureResponse handle(AddExpenditureRequest request) {
        DatabaseSqlManager.getInstance().createExpenditureDao().createExpenditure(request.getExpenditure());
        return new AddExpenditureResponse(request.getExpenditure());

    }

    @Override
    protected AddExpenditureResponse fail(Exception e) {
        return new AddExpenditureResponse(e.getMessage());
    }
}
