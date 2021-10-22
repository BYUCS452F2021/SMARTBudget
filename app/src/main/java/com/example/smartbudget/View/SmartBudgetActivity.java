package com.example.smartbudget.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;

public abstract class SmartBudgetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseSqlManager.setCurrContext(this);
    }
}
