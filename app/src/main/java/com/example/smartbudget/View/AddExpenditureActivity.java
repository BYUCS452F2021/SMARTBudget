package com.example.smartbudget.View;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.Model.User;
import com.example.smartbudget.Presenter.AddExpenditurePresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.AddExpenditureResponse;
import com.example.smartbudget.Response.GetCategoriesResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddExpenditureActivity extends SmartBudgetActivity implements AddExpenditurePresenter.AddExpenditureView {

    private Spinner categorySpinner;
    private EditText expenditureDescription;
    private EditText expenditureAmount;
    private AddExpenditurePresenter presenter;
    private List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenditure);

        Button addExpenditureBtn = findViewById(R.id.add_expenditure_btn);
        categorySpinner = findViewById(R.id.expenditure_category_spinner);
        expenditureDescription = findViewById(R.id.expenditure_description_input);
        expenditureAmount = findViewById(R.id.expenditure_amount_input);
        presenter = new AddExpenditurePresenter(this);
        DataCache.getInstance().setCurrCategories(new ArrayList<>());
        categories = DataCache.getInstance().getCurrCategories();

        addExpenditureBtn.setOnClickListener(v->addExpenditure());
        presenter.getCategories(DataCache.getInstance().getBudget());

    }

    private String[] makeStringArray(List<Category> categoryList){
        String[] arr = new String[categoryList.size()];
        for (int i = 0; i < categoryList.size(); ++i){
            arr[i] = categoryList.get(i).getName();
        }
        return arr;
    }

    private void addExpenditure(){
        User user = DataCache.getInstance().getCurrUser();
        Category category = DataCache.getInstance().getCurrCategory();
        LocalDate date =  DataCache.getInstance().getCurrDate();
        if (expenditureDescription.getText().toString().isEmpty()){
            Toast.makeText(this,
                    "Please enter a description for your expenditure",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (expenditureAmount.getText().toString().isEmpty()){
            Toast.makeText(this,
                    "Please enter an amount for your expenditure",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.addExpenditure(
                new Expenditure(category,
                        expenditureDescription.getText().toString(),
                        Float.parseFloat(expenditureAmount.getText().toString()),
                        date),
                user
        );
    }

    @Override
    public void expenditureAdded(AddExpenditureResponse response) {
        if (response.isSuccess()){
            DataCache.getInstance().getCurrExpenditure().add(response.getExpenditure());
            finish();
        }
        else {
            runOnUiThread(() -> {
                Toast.makeText(this,
                        "Adding an expenditure didn't work out",
                        Toast.LENGTH_SHORT).show();
            });
        }
    }

    @Override
    public void categoriesLoaded(GetCategoriesResponse response) {
        if (response.getCategories() == null || response.getCategories().isEmpty()){
            finish();
            return;
        }
        DataCache.getInstance().updateCategories(response.getCategories());
        DataCache.getInstance().setCurrCategory(categories.get(0));

        categorySpinner.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        final String[] personNames = makeStringArray(categories);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, personNames);
        categorySpinner.setAdapter(arrayAdapter);

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DataCache.getInstance().setCurrCategory(categories.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}