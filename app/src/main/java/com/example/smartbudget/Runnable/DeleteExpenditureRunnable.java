package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.ViewExpenditurePresenter;
import com.example.smartbudget.Request.DeleteExpenditureRequest;
import com.example.smartbudget.ServerProxy;

public class DeleteExpenditureRunnable implements Runnable{
    private ViewExpenditurePresenter presenter;
    private DeleteExpenditureRequest request;

    public DeleteExpenditureRunnable(ViewExpenditurePresenter presenter, DeleteExpenditureRequest request) {
        this.presenter = presenter;
        this.request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        presenter.expenditureDeleted(new ServerProxy().deleteExpenditure(request));
    }
}
