package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.GetCategoriesPresenter;
import com.example.smartbudget.Request.GetCategoriesRequest;
import com.example.smartbudget.ServerProxy;

public class GetCategoriesRunnable implements Runnable{
    private GetCategoriesPresenter _presenter;
    private GetCategoriesRequest _request;

    public GetCategoriesRunnable(GetCategoriesPresenter presenter, GetCategoriesRequest request){
        _presenter = presenter;
        _request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        ServerProxy proxy = new ServerProxy();
        _presenter.categoriesLoaded(proxy.getCategories(_request));
    }
}
