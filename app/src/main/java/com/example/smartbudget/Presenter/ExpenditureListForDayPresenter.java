package com.example.smartbudget.Presenter;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.Model.User;
import com.example.smartbudget.Request.DeleteExpenditureRequest;
import com.example.smartbudget.Request.GetBudgetsRequest;
import com.example.smartbudget.Request.GetExpendituresForDayRequest;
import com.example.smartbudget.Response.DeleteExpenditureResponse;
import com.example.smartbudget.Response.GetBudgetResponse;
import com.example.smartbudget.Response.GetExpenditureForDayResponse;
import com.example.smartbudget.Runnable.DeleteExpenditureRunnable;
import com.example.smartbudget.Runnable.GetBudgetsRunnable;
import com.example.smartbudget.Runnable.GetExpendituresForDayRunnable;

public class ExpenditureListForDayPresenter implements ViewExpenditurePresenter{
    public interface ExpenditureListForDayView {
        void listFetched(GetExpenditureForDayResponse response);
        void expenditureDeleted(DeleteExpenditureResponse response);
    }

    private ExpenditureListForDayView _view;
    private GetExpendituresForDayRunnable _runnable;

    public ExpenditureListForDayPresenter(ExpenditureListForDayView view){
        _view = view;
    }

    public void getExpendituresForDay(Budget budget){
        GetExpendituresForDayRequest request = new GetExpendituresForDayRequest(budget,
                DataCache.getInstance().getCurrDate().getYear(),
                DataCache.getInstance().getCurrDate().getMonthValue(),
                DataCache.getInstance().getCurrDate().getDayOfMonth());
        _runnable = new GetExpendituresForDayRunnable(this, request);
        new Thread(_runnable).start();
    }

    @Override
    public void listFetched(GetExpenditureForDayResponse response){
        _view.listFetched(response);
    }

    public void deleteExpenditure(Expenditure expenditure){
        DeleteExpenditureRequest request = new DeleteExpenditureRequest(expenditure);
        DeleteExpenditureRunnable runnable = new DeleteExpenditureRunnable(this, request);
        new Thread(runnable).start();
    }

    @Override
    public void expenditureDeleted(DeleteExpenditureResponse response) {
        _view.expenditureDeleted(response);
    }
}
