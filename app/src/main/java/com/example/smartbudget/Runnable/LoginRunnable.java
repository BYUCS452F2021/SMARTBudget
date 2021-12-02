package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.LoginPresenter;
import com.example.smartbudget.Request.LoginRequest;
import com.example.smartbudget.ServerProxy;

public class LoginRunnable implements Runnable{

    private LoginPresenter _presenter;
    private LoginRequest _request;

    public LoginRunnable(LoginPresenter presenter, LoginRequest request){
        _presenter = presenter;
        _request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        ServerProxy proxy = new ServerProxy();
        _presenter.loginDone(proxy.login(_request));
    }
}
