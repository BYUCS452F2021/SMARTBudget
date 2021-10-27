package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.AddCategoryRequest;
import com.example.smartbudget.Response.AddCategoryResponse;

public class AddCategoryHandler {
    public AddCategoryResponse addCategory(AddCategoryRequest request){
        try {
            DatabaseSqlManager.getInstance().createCategoryDao().create(request.getCategory(), request.getBudget());
            return new AddCategoryResponse(request.getCategory());
        } catch (Exception e) {
            return new AddCategoryResponse(e.getMessage());
        }
    }
}
