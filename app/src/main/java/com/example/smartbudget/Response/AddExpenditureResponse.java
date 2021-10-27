package com.example.smartbudget.Response;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Expenditure;

public class AddExpenditureResponse extends Response{
    private Expenditure expenditure;

    public AddExpenditureResponse(String message) {
        super(message);
    }

    public AddExpenditureResponse(Expenditure expenditure) {
        super();
        this.expenditure = expenditure;
    }

    public Expenditure getExpenditure() {
        return expenditure;
    }
}
