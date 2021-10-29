package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.BudgetListPresenter;
import com.example.smartbudget.Request.DeleteBudgetRequest;
import com.example.smartbudget.ServerProxy;

public class DeleteBudgetRunnable implements Runnable{
    private BudgetListPresenter presenter;
    private DeleteBudgetRequest request;

    public DeleteBudgetRunnable(BudgetListPresenter presenter, DeleteBudgetRequest request) {
        this.presenter = presenter;
        this.request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        presenter.budgetDeleted(new ServerProxy().deleteBudget(request));
    }
}
