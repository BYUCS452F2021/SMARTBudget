package com.example.smartbudget.Request;

import com.example.smartbudget.Model.User;

public class GetBudgetsRequest {
    User user;

    public GetBudgetsRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
