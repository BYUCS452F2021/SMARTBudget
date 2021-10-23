package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.AddBudgetPresenter;
import com.example.smartbudget.Request.AddBudgetRequest;
import com.example.smartbudget.ServerProxy;

public class AddBudgetRunnable implements Runnable{
    private AddBudgetPresenter presenter;
    private AddBudgetRequest request;

    public AddBudgetRunnable(AddBudgetPresenter presenter, AddBudgetRequest request) {
        this.presenter = presenter;
        this.request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        presenter.budgetAdded(new ServerProxy().addBudget(request));
    }
}
