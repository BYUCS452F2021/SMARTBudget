package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.DeleteCategoryRequest;
import com.example.smartbudget.Response.DeleteCategoryResponse;

public class DeleteCategoryHandler extends Handler<DeleteCategoryRequest, DeleteCategoryResponse> {
    @Override
    protected DeleteCategoryResponse handle(DeleteCategoryRequest request) {
        DatabaseSqlManager.getInstance().createCategoryDao().delete(request.getCategory());
        return new DeleteCategoryResponse(request.getCategory());
    }

    @Override
    protected DeleteCategoryResponse fail(Exception e) {
        return new DeleteCategoryResponse(e.getMessage());
    }
}
