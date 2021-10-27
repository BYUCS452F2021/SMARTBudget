package com.example.smartbudget.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import androidx.annotation.NonNull;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.R;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class MainBudgetDashboardActivity extends SmartBudgetActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_budget_dashboard);

        CalendarView calendar = findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            DataCache.getInstance().setCurrDate(LocalDate.of(year, month, dayOfMonth));
            launchDayViewActivity();
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v->launchCategoryViewActivity());
    }

    private void launchCategoryViewActivity() {
        DataCache.getInstance().setCurrCategories(new ArrayList<>()); // FIXME maybe. Should this get current categories?
        Intent intent = new Intent(this, SelectCategoryActivity.class);
        startActivity(intent);
    }

    private void launchDayViewActivity(){
        Intent intent = new Intent(this, ViewDaysExpendituresActivity.class);
        startActivity(intent);
    }

}