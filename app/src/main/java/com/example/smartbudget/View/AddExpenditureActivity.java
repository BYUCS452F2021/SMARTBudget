package com.example.smartbudget.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.Presenter.AddExpenditurePresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.AddExpenditureResponse;

public class AddExpenditureActivity extends SmartBudgetActivity implements AddExpenditurePresenter.AddExpenditureView {

    private Spinner category; //TODO Easton :)))))))
    private EditText expenditureDescription;
    private EditText expenditureAmount;
    private AddExpenditurePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenditure);

        Button addExpenditureBtn = findViewById(R.id.add_expenditure_btn);
        expenditureDescription = findViewById(R.id.expenditure_description_input);
        expenditureAmount = findViewById(R.id.expenditure_amount_input);
        presenter = new AddExpenditurePresenter(this);

        addExpenditureBtn.setOnClickListener(v->addExpenditure());
    }

    private void addExpenditure(){
        if (expenditureDescription.getText().toString().isEmpty()){
            Toast.makeText(this,
                    "Please enter a description for your expenditure",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.addExpenditure(
                new Expenditure(expenditureDescription.getText().toString()),
                DataCache.getInstance().getCurrUser()
        );

        if (expenditureAmount.getText().toString().isEmpty()){
            Toast.makeText(this,
                    "Please enter an amount for your expenditure",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.addExpenditure(
                new Expenditure(expenditureAmount.getText().toString()),
                DataCache.getInstance().getCurrUser()
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
}