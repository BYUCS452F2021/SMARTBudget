package com.example.smartbudget.Presenter;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.User;
import com.example.smartbudget.Request.AddBudgetRequest;
import com.example.smartbudget.Response.AddBudgetResponse;
import com.example.smartbudget.Runnable.AddBudgetRunnable;

public class AddBudgetPresenter {
    public interface AddBudgetView{
        public void budgetAdded(AddBudgetResponse response);
    }

    private AddBudgetView view;

    public AddBudgetPresenter(AddBudgetView view) {
        this.view = view;
    }

    public void addBudget(Budget budget, User user){
        AddBudgetRequest request = new AddBudgetRequest(budget, user);
        AddBudgetRunnable runnable = new AddBudgetRunnable(this, request);
        new Thread(runnable).start();
    }

    public void budgetAdded(AddBudgetResponse response){
        view.budgetAdded(response);
    }
}
