package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.GetCategoriesPresenter;
import com.example.smartbudget.Request.DeleteCategoryRequest;
import com.example.smartbudget.ServerProxy;

public class DeleteCategoryRunnable implements Runnable{
    private GetCategoriesPresenter presenter;
    private DeleteCategoryRequest request;

    public DeleteCategoryRunnable(GetCategoriesPresenter presenter, DeleteCategoryRequest request) {
        this.presenter = presenter;
        this.request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        presenter.categoryDeleted(new ServerProxy().deleteCategory(request));
    }
}
