package com.example.smartbudget.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.smartbudget.R;

public class AddExpenditureActivity extends SmartBudgetActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenditure);

        Button addExpenditureBtn = findViewById(R.id.add_expenditure_btn);
        addExpenditureBtn.setOnClickListener(v->addExpenditure());
    }

    private void addExpenditure(){
        // TODO make this actually add an expenditure
        finish();
    }
}