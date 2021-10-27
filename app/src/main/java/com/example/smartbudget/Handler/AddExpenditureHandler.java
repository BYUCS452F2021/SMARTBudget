package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.AddExpenditureRequest;
import com.example.smartbudget.Response.AddExpenditureResponse;

public class AddExpenditureHandler {
    public AddExpenditureResponse addExpenditure(AddExpenditureRequest request){
        try {
            DatabaseSqlManager.getInstance().createExpenditureDao().createExpenditure(request.getExpenditure());
            return new AddExpenditureResponse(request.getExpenditure());
        } catch (Exception e) {
            return new AddExpenditureResponse(e.getMessage());
        }
    }

}
