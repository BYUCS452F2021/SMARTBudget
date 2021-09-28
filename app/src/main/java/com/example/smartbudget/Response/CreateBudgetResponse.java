package com.example.smartbudget.Response;

import java.util.UUID;

public class CreateBudgetResponse {
    private boolean isSuccess;
    private UUID  budgetID;
    private String message;

    public CreateBudgetResponse() {
    }

    public CreateBudgetResponse(boolean isSuccess, UUID budgetID) {
        this.isSuccess = isSuccess;
        this.budgetID = budgetID;
    }

    public CreateBudgetResponse(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public CreateBudgetResponse(boolean isSuccess) {
        this.isSuccess = isSuccess;
    };

    public CreateBudgetResponse(String message) {
        this.message = message;
        isSuccess = false;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public UUID getBudgetID() {
        return budgetID;
    }

    public String getMessage() {
        return message;
    }
}
