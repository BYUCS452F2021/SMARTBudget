package com.example.smartbudget.Presenter;

import com.example.smartbudget.Request.LoginRequest;
import com.example.smartbudget.Request.RegisterRequest;
import com.example.smartbudget.Response.LoginResponse;
import com.example.smartbudget.Response.RegisterResponse;
import com.example.smartbudget.Runnable.LoginRunnable;
import com.example.smartbudget.Runnable.RegisterRunnable;
import com.example.smartbudget.ServerProxy;

public class RegisterPresenter {

    public interface RegisterView{
        public void registerDone(RegisterResponse response);
    }

    private RegisterPresenter.RegisterView _registerView;
    private RegisterRunnable _runnable;

    public RegisterPresenter(RegisterPresenter.RegisterView registerView){
        _registerView = registerView;
    }

    public void register(String username, String password){
        RegisterRequest request = new RegisterRequest(username, password);
        _runnable = new RegisterRunnable(this, request);
        new Thread(_runnable).start();
    }

    public void registerDone(RegisterResponse response){
        _registerView.registerDone(response);
    }

}
