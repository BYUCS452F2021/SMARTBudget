package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Model.User;
import com.example.smartbudget.Request.RegisterRequest;
import com.example.smartbudget.Response.RegisterResponse;

public class RegisterHandler {

    public RegisterResponse register(RegisterRequest request){
        try {
            UserDao dao = DatabaseSqlManager.getInstance().createUserDao();
            User newUser = new User(request.getUsername(), request.getPassword());
            dao.createUser(newUser);
            return new RegisterResponse(true, newUser, "Sucess!");
        } catch (Exception e) {
            return new RegisterResponse(false, e.getMessage());
        }
    }
}
