package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.UpdateBudgetPresenter;
import com.example.smartbudget.Request.UpdateBudgetRequest;
import com.example.smartbudget.ServerProxy;

public class UpdateBudgetRunnable implements Runnable{
    UpdateBudgetPresenter presenter;
    UpdateBudgetRequest request;

    public UpdateBudgetRunnable(UpdateBudgetPresenter presenter, UpdateBudgetRequest request) {
        this.presenter = presenter;
        this.request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        presenter.budgetUpdated(new ServerProxy().updateBudget(request));
    }
}
