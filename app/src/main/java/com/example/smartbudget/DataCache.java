package com.example.smartbudget;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.User;

public class DataCache {
    private static DataCache _instance;
    private User _currUser;
    private Budget _budget;

    private DataCache() {
    }

    public static DataCache getInstance(){
        if (_instance == null){
            return new DataCache();
        }
        else {
            return _instance;
        }
    }

    public User getCurrUser() {
        return _currUser;
    }

    public void setCurrUser(User _currUser) {
        this._currUser = _currUser;
    }

    public Budget getBudget() {
        return _budget;
    }

    public void setBudget(Budget _budget) {
        this._budget = _budget;
    }
}
