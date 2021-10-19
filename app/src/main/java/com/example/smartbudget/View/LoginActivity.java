package com.example.smartbudget.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartbudget.Presenter.LoginPresenter;
import com.example.smartbudget.Presenter.RegisterPresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.LoginResponse;
import com.example.smartbudget.Response.RegisterResponse;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.LoginView, RegisterPresenter.RegisterView {
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
            displayMessage = "Success! Logging in...";
        }else{
            displayMessage = "Incorrect username or password";
        }
        this.runOnUiThread(
                () -> Toast.makeText(getApplicationContext(), displayMessage, Toast.LENGTH_SHORT).show()
            );
    }

    @Override
    public void registerDone(RegisterResponse response) {
        String displayMessage;
        if(response.getSuccess()){
            displayMessage = "Registered! Logging in...";
        }else{
            displayMessage = "Registration failed";
        }
        this.runOnUiThread(
                () -> Toast.makeText(getApplicationContext(), displayMessage, Toast.LENGTH_SHORT).show()
        );
    }
}