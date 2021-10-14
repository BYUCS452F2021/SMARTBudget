package com.example.smartbudget.Presenter;

import com.example.smartbudget.Request.LoginRequest;
import com.example.smartbudget.Request.RegisterRequest;
import com.example.smartbudget.Response.LoginResponse;
import com.example.smartbudget.Response.RegisterResponse;
import com.example.smartbudget.Runnable.LoginRunnable;
import com.example.smartbudget.ServerProxy;
import com.example.smartbudget.View.LoginActivity;

public class LoginPresenter {

    public interface LoginView{
        public void loginDone(LoginResponse response);
    }

    private LoginView _loginView;
    private LoginRunnable _runnable;

    public LoginPresenter(LoginView loginView){
        _loginView = loginView;
    }

    public void login(String username, String password){
        LoginRequest request = new LoginRequest(username, password);
        _runnable = new LoginRunnable(this, request);
        new Thread(_runnable).start();
    }

    public void loginDone(LoginResponse response){
        _loginView.loginDone(response);
    }

}
