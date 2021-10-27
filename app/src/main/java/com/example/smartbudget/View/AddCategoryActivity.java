package com.example.smartbudget.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Presenter.AddBudgetPresenter;
import com.example.smartbudget.Presenter.AddCategoryPresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.AddCategoryResponse;

public class AddCategoryActivity extends SmartBudgetActivity implements AddCategoryPresenter.AddCategoryView {

    private EditText categoryInput;
    private AddCategoryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget); // FIXME to another view later

        Button addCategoryBtn = findViewById(R.id.finish_budget_btn);
        categoryInput = findViewById(R.id.budget_input_view);
        presenter = new AddCategoryPresenter(this);

        addCategoryBtn.setOnClickListener(v-> addCategory());
    }

    private void addCategory(){
        if (categoryInput.getText().toString().isEmpty()){
            Toast.makeText(this,
                    "Please enter a name for your category",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.addCategory(
                DataCache.getInstance().getBudget(),
                new Category(categoryInput.getText().toString(), 0)
        );
    }

    @Override
    public void categoryAdded(AddCategoryResponse response) {
        if (response.isSuccess()){
            DataCache.getInstance().getCurrCategories().add(response.getCategory());
            finish();
        }
        else {
            runOnUiThread(() -> {
                Toast.makeText(this,
                        "Adding a category didn't work out",
                        Toast.LENGTH_SHORT).show();
            });
        }
    }
}
