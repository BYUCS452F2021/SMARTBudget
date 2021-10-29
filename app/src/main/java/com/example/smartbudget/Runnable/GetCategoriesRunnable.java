package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.CategoryListPresenter;
import com.example.smartbudget.Request.GetCategoriesRequest;
import com.example.smartbudget.ServerProxy;

public class GetCategoriesRunnable implements Runnable{
    private CategoryListPresenter _presenter;
    private GetCategoriesRequest _request;

    public GetCategoriesRunnable(CategoryListPresenter presenter, GetCategoriesRequest request){
        _presenter = presenter;
        _request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        ServerProxy proxy = new ServerProxy();
        _presenter.listFetched(proxy.getCategories(_request));
    }
}
