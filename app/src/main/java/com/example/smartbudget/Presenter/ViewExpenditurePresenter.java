package com.example.smartbudget.Presenter;

import com.example.smartbudget.Response.DeleteExpenditureResponse;
import com.example.smartbudget.Response.GetExpenditureForDayResponse;

public interface ViewExpenditurePresenter {
    void listFetched(GetExpenditureForDayResponse response);
    void expenditureDeleted(DeleteExpenditureResponse response);
}
