package com.example.smartbudget.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Presenter.UpdateBudgetPresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.UpdateBudgetResponse;

import java.util.List;

public class UpdateBudgetActivity extends BudgetEditActivity implements UpdateBudgetPresenter.UpdateBudgetView {
    private UpdateBudgetPresenter presenter;
    private Budget budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new UpdateBudgetPresenter(this);

        budget = DataCache.getInstance().getBudget();
        budgetInput.setText(budget.getName());

        addBudgetBtn.setOnClickListener(v->updateBudget());
    }

    private void updateBudget(){
        presenter.updateBudget(
            new Budget(
                budget.getBudgetID(),
                budgetInput.getText().toString(),
                budget.getTimestamp()
            ),
                DataCache.getInstance().getCurrUser()
        );
    }

    @Override
    public void budgetUpdated(UpdateBudgetResponse response) {
        List<Budget> budgets = DataCache.getInstance().getCurrBudgets();
        int pos = budgets.indexOf(budget);
        budgets.set(pos, response.getUpdatedBudget());
        finish();
    }
}