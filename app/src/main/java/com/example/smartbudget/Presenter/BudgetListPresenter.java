package com.example.smartbudget.Presenter;

import com.example.smartbudget.Model.User;
import com.example.smartbudget.Request.GetBudgetsRequest;
import com.example.smartbudget.Response.GetBudgetResponse;
import com.example.smartbudget.Runnable.GetBudgetsRunnable;

public class BudgetListPresenter {
    public interface BudgetListView{
        public void listFetched(GetBudgetResponse response);
    }

    private BudgetListView _view;
    private GetBudgetsRunnable _runnable;

    public BudgetListPresenter(BudgetListView view){
        _view = view;
    }

    public void getBudgets(User user){
        GetBudgetsRequest request = new GetBudgetsRequest(user);
        _runnable = new GetBudgetsRunnable(this, request);
        new Thread(_runnable).start();
    }

    public void listFetched(GetBudgetResponse response){
        _view.listFetched(response);
    }
}
