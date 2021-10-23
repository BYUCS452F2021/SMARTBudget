package com.example.smartbudget;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.User;

import java.util.List;

public class DataCache {
    private static DataCache _instance;
    private User _currUser;
    private List<Budget> _currBudgets;
    private Budget _budget;

    private DataCache() {
    }

    public static DataCache getInstance(){
        if (_instance == null){
            _instance = new DataCache();
        }
        return _instance;
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

    public void setBudget(int position) {
        this._budget = _currBudgets.get(position);
    }

    public List<Budget> getCurrBudgets() {
        return _currBudgets;
    }

    public void setCurrBudgets(List<Budget> currBudgets) {
        this._currBudgets = currBudgets;
    }

    public void updateBudgets(List<Budget> newBudgets){
        this._currBudgets.clear();
        _currBudgets.addAll(newBudgets);
    }
}
