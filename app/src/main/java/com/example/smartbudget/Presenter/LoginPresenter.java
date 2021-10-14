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
    private ServerProxy _serverProxy;
    private LoginRunnable _runnable;

    public LoginPresenter(LoginView loginView){
        _loginView = loginView;
        _serverProxy = new ServerProxy();
    }

    public void login(String username, String password){
        LoginRequest request = new LoginRequest(username, password);
        _runnable = new LoginRunnable(this, request);
        new Thread(_runnable).start();
    }

    public void loginDone(LoginResponse response){
        _loginView.loginDone(response);
    }

    public void register(String username, String password){
        RegisterRequest request = new RegisterRequest(username, password);
        RegisterResponse response = _serverProxy.register(request);
        if(response.getSuccess()){
            //TODO: make this do register success
        }
        else{
            //TODO: make the view pop up a failed toast
        }
    }


}
