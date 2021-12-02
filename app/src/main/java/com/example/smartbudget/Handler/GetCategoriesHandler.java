package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.GetCategoriesRequest;
import com.example.smartbudget.Response.GetCategoriesResponse;


public class GetCategoriesHandler extends Handler<GetCategoriesRequest, GetCategoriesResponse> {
    @Override
    protected GetCategoriesResponse handle(GetCategoriesRequest request) {
        return new GetCategoriesResponse(DatabaseSqlManager.getInstance().createCategoryDao().getCategories(request.getBudget()));
    }

    @Override
    protected GetCategoriesResponse fail(Exception e) {
        return new GetCategoriesResponse(e.getMessage());
    }
}
