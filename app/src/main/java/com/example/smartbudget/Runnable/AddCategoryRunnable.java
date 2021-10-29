package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.AddCategoryPresenter;
import com.example.smartbudget.Request.AddCategoryRequest;
import com.example.smartbudget.ServerProxy;

public class AddCategoryRunnable implements Runnable {
    private AddCategoryPresenter presenter;
    private AddCategoryRequest request;

    public AddCategoryRunnable(AddCategoryPresenter presenter, AddCategoryRequest request) {
        this.presenter = presenter;
        this.request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        presenter.categoryAdded(new ServerProxy().addCategory(request));
    }
}
