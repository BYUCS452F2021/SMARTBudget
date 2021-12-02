package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.AddCategoryRequest;
import com.example.smartbudget.Response.AddCategoryResponse;

public class AddCategoryHandler extends Handler<AddCategoryRequest, AddCategoryResponse> {
    @Override
    protected AddCategoryResponse handle(AddCategoryRequest request) {
        DatabaseSqlManager.getInstance().createCategoryDao().create(request.getCategory(), request.getBudget());
        return new AddCategoryResponse(request.getCategory());
    }

    @Override
    protected AddCategoryResponse fail(Exception e) {
        return new AddCategoryResponse(e.getMessage());
    }
}
