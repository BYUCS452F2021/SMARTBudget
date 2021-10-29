package com.example.smartbudget.Runnable;

import android.os.Looper;

import com.example.smartbudget.Presenter.ExpenditureListForDayPresenter;
import com.example.smartbudget.Request.GetExpendituresForDayRequest;
import com.example.smartbudget.ServerProxy;

public class GetExpendituresForDayRunnable implements Runnable {
    private ExpenditureListForDayPresenter _presenter;
    private GetExpendituresForDayRequest _request;

    public GetExpendituresForDayRunnable(ExpenditureListForDayPresenter presenter, GetExpendituresForDayRequest request){
        _presenter = presenter;
        _request = request;
    }

    @Override
    public void run() {
        Looper.prepare();
        ServerProxy proxy = new ServerProxy();
        _presenter.listFetched(proxy.getExpenditures(_request));
    }
}
