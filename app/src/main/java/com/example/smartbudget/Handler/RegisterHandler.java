package com.example.smartbudget.Handler;

import com.example.smartbudget.Request.RegisterRequest;
import com.example.smartbudget.Response.RegisterResponse;

public class RegisterHandler {

    public RegisterResponse register(RegisterRequest request){
        return new RegisterResponse(true, null, null);
//        DaoFactory manager = DatabaseSqlManager.getInstance();
//        UserDao userDao = manager.createUserDao();
//
//        //TODO: make this make sure username not taken, then create a user and log in.
//
//        return new RegisterResponse(true, null, null);
    }
}
