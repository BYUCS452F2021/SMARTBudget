package com.example.smartbudget.Request;

public class CreateBudgetRequest {
    private String user;
    private String password;
    private float spendingGoal;

    public CreateBudgetRequest(String user, String password, float spendingGoal) {
        this.user = user;
        this.password = password;
        this.spendingGoal = spendingGoal;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public float getSpendingGoal() {
        return spendingGoal;
    }
}
