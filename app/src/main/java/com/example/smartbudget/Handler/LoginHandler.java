package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Request.LoginRequest;
import com.example.smartbudget.Response.LoginResponse;

public class LoginHandler {

    public LoginResponse login(LoginRequest request){
        try {
            DatabaseSqlManager manager = new DatabaseSqlManager("appDatabase");

        } catch (DataAccessException e){
            return new LoginResponse(false, "Data access failure");
        }
    }
}
