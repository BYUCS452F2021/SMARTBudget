package com.example.smartbudget.Presenter;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.User;
import com.example.smartbudget.Request.AddBudgetRequest;
import com.example.smartbudget.Request.UpdateBudgetRequest;
import com.example.smartbudget.Response.AddBudgetResponse;
import com.example.smartbudget.Response.UpdateBudgetResponse;
import com.example.smartbudget.Runnable.AddBudgetRunnable;
import com.example.smartbudget.Runnable.UpdateBudgetRunnable;

public class UpdateBudgetPresenter {
    public interface UpdateBudgetView {
        void budgetUpdated(UpdateBudgetResponse response);
    }

    private UpdateBudgetView view;

    public UpdateBudgetPresenter(UpdateBudgetView view) {
        this.view = view;
    }

    public void updateBudget(Budget budget, User user){
        UpdateBudgetRequest request = new UpdateBudgetRequest(budget, user);
        UpdateBudgetRunnable runnable = new UpdateBudgetRunnable(this, request);
        new Thread(runnable).start();
    }

    public void budgetUpdated(UpdateBudgetResponse response){
        view.budgetUpdated(response);
    }
}
