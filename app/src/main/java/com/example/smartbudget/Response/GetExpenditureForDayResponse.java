package com.example.smartbudget.Response;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Expenditure;

import java.util.List;

public class GetExpenditureForDayResponse extends Response{
    private List<Expenditure> expenditures;

    public GetExpenditureForDayResponse() {
    }

    public GetExpenditureForDayResponse(String message) {
        super(message);
    }

    public GetExpenditureForDayResponse(List<Expenditure> expenditures) {
        super();
        this.expenditures = expenditures;
    }

    public List<Expenditure> getExpenditures() {
        return expenditures;
    }
}
