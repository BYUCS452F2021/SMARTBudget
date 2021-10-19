package com.example.smartbudget.Response;

import com.example.smartbudget.Model.User;

public class LoginResponse {
    private boolean _success;
    private User _user;
    private String _message;

    public LoginResponse(boolean success, User user, String message){
        _success = success;
        _user = user;
        _message = message;
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
