package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.BudgetListPresenter;
import com.example.smartbudget.Request.GetBudgetsRequest;
import com.example.smartbudget.ServerProxy;

public class GetBudgetsRunnable implements Runnable{
    private BudgetListPresenter _presenter;
    private GetBudgetsRequest _request;

    public GetBudgetsRunnable(BudgetListPresenter presenter, GetBudgetsRequest request){
        _presenter = presenter;
        _request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        ServerProxy proxy = new ServerProxy();
        _presenter.listFetched(proxy.getBudgets(_request));
    }
}
