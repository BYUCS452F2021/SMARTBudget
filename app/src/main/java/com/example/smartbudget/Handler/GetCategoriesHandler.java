package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.GetCategoriesRequest;
import com.example.smartbudget.Response.GetCategoriesResponse;


public class GetCategoriesHandler {
    public GetCategoriesResponse getCategories(GetCategoriesRequest request){
        try {
            return new GetCategoriesResponse(DatabaseSqlManager.getInstance().createCategoryDao().getCategories(request.getBudget()));
        } catch (Exception e) {
            return new GetCategoriesResponse(e.getMessage());
        }
    }
}
