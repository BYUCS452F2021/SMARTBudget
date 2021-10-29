package com.example.smartbudget.Presenter;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Request.AddCategoryRequest;
import com.example.smartbudget.Response.AddCategoryResponse;
import com.example.smartbudget.Runnable.AddCategoryRunnable;

public class AddCategoryPresenter {
    public interface AddCategoryView{
        public void categoryAdded(AddCategoryResponse response);
    }

    private AddCategoryView view;

    public AddCategoryPresenter(AddCategoryView view) {
        this.view = view;
    }

    public void addCategory(Budget budget, Category category){
        AddCategoryRequest request = new AddCategoryRequest(category, budget);
        AddCategoryRunnable runnable = new AddCategoryRunnable(this, request);
        new Thread(runnable).start();
    }

    public void categoryAdded(AddCategoryResponse response){
        view.categoryAdded(response);
    }
}
