package com.example.smartbudget.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.smartbudget.R;

public class AddBudgetActivity extends SmartBudgetActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);
        Button addBudgetBtn = findViewById(R.id.add_budget_btn);
        EditText budgetInput = findViewById(R.id.budget_input_view);
    }
}