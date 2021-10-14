package com.example.smartbudget.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartbudget.Presenter.LoginPresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.LoginResponse;
import com.example.smartbudget.Runnable.LoginRunnable;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.LoginView {
    private LoginPresenter _presenter;
    private Button _loginButton;
    private EditText _loginNameTextBox;
    private EditText _loginPasswordTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _presenter = new LoginPresenter(this);

        _loginButton = findViewById(R.id.loginButton);
        _loginNameTextBox = findViewById(R.id.loginNameTextBox);
        _loginPasswordTextBox = findViewById(R.id.loginPasswordTextBox);

        _loginButton.setOnClickListener(l -> onClickLogin());

    }

    private void onClickLogin(){
        String username = _loginNameTextBox.getText().toString();
        String password = _loginPasswordTextBox.getText().toString();
        _presenter.login(username, password);
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
}