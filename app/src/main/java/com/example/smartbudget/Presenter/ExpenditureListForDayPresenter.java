package com.example.smartbudget.Presenter;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.User;
import com.example.smartbudget.Request.GetBudgetsRequest;
import com.example.smartbudget.Request.GetExpendituresForDayRequest;
import com.example.smartbudget.Response.GetBudgetResponse;
import com.example.smartbudget.Response.GetExpenditureForDayResponse;
import com.example.smartbudget.Runnable.GetBudgetsRunnable;
import com.example.smartbudget.Runnable.GetExpendituresForDayRunnable;

public class ExpenditureListForDayPresenter {
    public interface ExpenditureListForDayView {
        public void listFetched(GetExpenditureForDayResponse response);

    }

    private ExpenditureListForDayView _view;
    private GetExpendituresForDayRunnable _runnable;

    public ExpenditureListForDayPresenter(ExpenditureListForDayView view){
        _view = view;
    }

    public void getExpendituresForDay(Budget budget){
        GetExpendituresForDayRequest request = new GetExpendituresForDayRequest(budget);
        _runnable = new GetExpendituresForDayRunnable(this, request);
        new Thread(_runnable).start();
    }

    public void listFetched(GetExpenditureForDayResponse response){
        _view.listFetched(response);
    }

}
