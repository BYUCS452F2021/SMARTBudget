package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.RegisterPresenter;
import com.example.smartbudget.Request.RegisterRequest;
import com.example.smartbudget.ServerProxy;

public class RegisterRunnable implements Runnable{
    private RegisterPresenter _presenter;
    private RegisterRequest _request;

    public RegisterRunnable(RegisterPresenter presenter, RegisterRequest request){
        _presenter = presenter;
        _request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        ServerProxy proxy = new ServerProxy();
        _presenter.registerDone(proxy.register(_request));
    }
}
