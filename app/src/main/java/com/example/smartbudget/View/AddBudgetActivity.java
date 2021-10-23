package com.example.smartbudget.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Presenter.AddBudgetPresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.AddBudgetResponse;

public class AddBudgetActivity extends SmartBudgetActivity implements AddBudgetPresenter.AddBudgetView {

    private EditText budgetInput;
    private AddBudgetPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);

        Button addBudgetBtn = findViewById(R.id.finish_budget_btn);
        budgetInput = findViewById(R.id.budget_input_view);
        presenter = new AddBudgetPresenter(this);

        addBudgetBtn.setOnClickListener(v-> addBudget());
    }

    private void addBudget(){
        if (budgetInput.getText().toString().isEmpty()){
            Toast.makeText(this,
                    "Please enter a name for your budget",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.addBudget(
                new Budget(budgetInput.getText().toString()),
                DataCache.getInstance().getCurrUser()
        );
    }

    @Override
    public void budgetAdded(AddBudgetResponse response) {
        if (response.isSuccess()){
            DataCache.getInstance().getCurrBudgets().add(response.getBudget());
            finish();
        }
        else {
            runOnUiThread(() -> {
                Toast.makeText(this,
                        "Adding a budget didn't work out",
                        Toast.LENGTH_SHORT).show();
            });
        }
    }
}