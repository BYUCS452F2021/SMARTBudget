package com.example.smartbudget.Response;

import com.example.smartbudget.Model.User;

public class LoginResponse {
    private boolean _success;
    private User _user;
    private String _message;

    public LoginResponse(boolean success, User user){
        _success = success;
        _user = user;
    }

    public LoginResponse(boolean _success, String _message) {
        this._success = _success;
        this._message = _message;
    }

    public boolean getSuccess(){
        return _success;
    }

    public User getUser(){
        return _user;
    }

    public String getMessage(){
        return _message;
    }
}
