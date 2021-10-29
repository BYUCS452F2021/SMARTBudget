package com.example.smartbudget.Request;

import com.example.smartbudget.Model.Expenditure;

public class DeleteExpenditureRequest {
    Expenditure expenditure;

    public DeleteExpenditureRequest(Expenditure expenditure) {
        this.expenditure = expenditure;
    }

    public Expenditure getExpenditure() {
        return expenditure;
    }
}
