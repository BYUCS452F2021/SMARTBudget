package com.example.smartbudget.Request;

public class LoginRequest {
    private String _username;
    private String _password;

    public LoginRequest(String username, String password){
        _username = username;
        _password = password;
    }

    public String getUsername(){
        return _username;
    }

    public String getPassword(){
        return _password;
    }
}
