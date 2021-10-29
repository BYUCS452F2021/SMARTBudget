package com.example.smartbudget.Request;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.User;

public class GetExpendituresForDayRequest {
    Budget budget;

    public GetExpendituresForDayRequest(Budget budget) {
        this.budget = budget;
    }

    public Budget getBudget() {
        return budget;
    }


}
