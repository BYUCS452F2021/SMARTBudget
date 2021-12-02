package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.AddExpenditurePresenter;
import com.example.smartbudget.Request.AddExpenditureRequest;
import com.example.smartbudget.ServerProxy;

public class AddExpenditureRunnable implements Runnable {
    private AddExpenditurePresenter presenter;
    private AddExpenditureRequest request;

    public AddExpenditureRunnable(AddExpenditurePresenter presenter, AddExpenditureRequest request) {
        this.presenter = presenter;
        this.request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        presenter.expenditureAdded(new ServerProxy().addExpenditure(request));
    }
}
