package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.DeleteCategoryRequest;
import com.example.smartbudget.Response.DeleteCategoryResponse;

public class DeleteCategoryHandler {
    public DeleteCategoryResponse deleteCategory(DeleteCategoryRequest request){
        try {
            DatabaseSqlManager.getInstance().createCategoryDao().delete(request.getCategory());
            return new DeleteCategoryResponse(request.getCategory());
        } catch (Exception e) {
            return new DeleteCategoryResponse(e.getMessage());
        }
    }
}
