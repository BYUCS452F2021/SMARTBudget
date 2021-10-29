package com.example.smartbudget.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;

public abstract class SmartBudgetActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        DatabaseSqlManager.setCurrContext(this);
    }
}
