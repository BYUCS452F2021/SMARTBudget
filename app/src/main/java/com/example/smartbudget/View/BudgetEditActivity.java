package com.example.smartbudget.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.smartbudget.Presenter.AddBudgetPresenter;
import com.example.smartbudget.R;

public abstract class BudgetEditActivity extends SmartBudgetActivity{
    protected EditText budgetInput;
    protected Button addBudgetBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);

        budgetInput = findViewById(R.id.budget_input_view);
        addBudgetBtn = findViewById(R.id.finish_budget_btn);
    }
}
