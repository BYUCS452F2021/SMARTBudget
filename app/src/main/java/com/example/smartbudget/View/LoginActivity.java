package com.example.smartbudget.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartbudget.DAO.relational.CategorySqlDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.DAO.relational.ExpenditureSqlDao;
import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.Presenter.LoginPresenter;
import com.example.smartbudget.Presenter.RegisterPresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.LoginResponse;
import com.example.smartbudget.Response.RegisterResponse;

public class LoginActivity extends SmartBudgetActivity implements LoginPresenter.LoginView, RegisterPresenter.RegisterView {
    private LoginPresenter _loginPresenter;
    private RegisterPresenter _registerPresenter;
    private Button _loginButton;
    private Button _registerButton;
    private EditText _loginNameTextBox;
    private EditText _loginPasswordTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _loginPresenter = new LoginPresenter(this);
        _registerPresenter = new RegisterPresenter(this);

        _loginButton = findViewById(R.id.loginButton);
        _registerButton = findViewById(R.id.registerButton);

        _loginNameTextBox = findViewById(R.id.loginNameTextBox);
        _loginPasswordTextBox = findViewById(R.id.loginPasswordTextBox);

        _loginButton.setOnClickListener(l -> onClickLogin());
        _registerButton.setOnClickListener(l -> onClickRegister());

    }

    private void onClickLogin(){
//        Budget budget = new Budget("test");
//        Category category = new Category("Name of Category", 0.0f);
//        Expenditure expenditure = new Expenditure(
//                category, "This is a description", 8.5f
//        );
//        DatabaseSqlManager.getInstance().createCategoryDao().createCategory(category, budget);
//        DatabaseSqlManager.getInstance().createExpenditureDao().createExpenditure(expenditure);
//        DatabaseSqlManager.getInstance().createExpenditureDao().getExpendituresForDay(budget, 2021, 10, 27);
        String username = _loginNameTextBox.getText().toString();
        String password = _loginPasswordTextBox.getText().toString();
        if(username.equals("") || password.equals("")){
            notifyPopulateTextFields();
            return;
        }
        _loginPresenter.login(username, password);
    }

    private void onClickRegister(){
        String username = _loginNameTextBox.getText().toString();
        String password = _loginPasswordTextBox.getText().toString();
        if(username.equals("") || password.equals("")){
            notifyPopulateTextFields();
            return;
        }
        _registerPresenter.register(username, password);
    }

    private void notifyPopulateTextFields(){
        String displayMessage = "Please fill in username and password fields!";
        Toast.makeText(getApplicationContext(), displayMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginDone(LoginResponse response) {
        String displayMessage;
        if(response.getSuccess()){
            DataCache.getInstance().setCurrUser(response.getUser());
            launchBudgetViewActvity();
        }else{
            displayMessage = "Incorrect username or password";
            this.runOnUiThread(
                    () -> Toast.makeText(getApplicationContext(), displayMessage, Toast.LENGTH_SHORT).show()
            );
        }
    }

    @Override
    public void registerDone(RegisterResponse response) {
        String displayMessage;
        if(response.getSuccess()){
            DataCache.getInstance().setCurrUser(response.getUser());
            launchBudgetViewActvity();
        }else{
            displayMessage = "Registration failed";
            this.runOnUiThread(
                    () -> Toast.makeText(getApplicationContext(), displayMessage, Toast.LENGTH_SHORT).show()
            );
        }
    }

    private void launchBudgetViewActvity(){
        Intent intent = new Intent(this, SelectBudgetActivity.class);
        startActivity(intent);
    }
}