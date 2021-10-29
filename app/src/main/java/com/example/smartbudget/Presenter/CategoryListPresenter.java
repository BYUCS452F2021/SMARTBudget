package com.example.smartbudget.Presenter;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Request.DeleteCategoryRequest;
import com.example.smartbudget.Request.GetCategoriesRequest;
import com.example.smartbudget.Response.DeleteCategoryResponse;
import com.example.smartbudget.Response.GetCategoriesResponse;
import com.example.smartbudget.Runnable.DeleteCategoryRunnable;
import com.example.smartbudget.Runnable.GetCategoriesRunnable;

public class CategoryListPresenter implements GetCategoriesPresenter {
    public interface CategoryListView{
        void listFetched(GetCategoriesResponse response);
        void categoryDeleted(DeleteCategoryResponse response);
    }

    private CategoryListView _view;
    private GetCategoriesRunnable _runnable;

    public CategoryListPresenter(CategoryListView view){
        _view = view;
    }

    public void getCategories(Budget budget){
        GetCategoriesRequest request = new GetCategoriesRequest(budget);
        _runnable = new GetCategoriesRunnable(this, request);
        new Thread(_runnable).start();
    }

    @Override
    public void categoriesLoaded(GetCategoriesResponse response){
        _view.listFetched(response);
    }

    @Override
    public void categoryDeleted(DeleteCategoryResponse response) {
        _view.categoryDeleted(response);
    }

    public void deleteCategories(Category category){
        DeleteCategoryRequest request = new DeleteCategoryRequest(category);
        DeleteCategoryRunnable runnable = new DeleteCategoryRunnable(this, request);
        new Thread(runnable).start();
    }
}
