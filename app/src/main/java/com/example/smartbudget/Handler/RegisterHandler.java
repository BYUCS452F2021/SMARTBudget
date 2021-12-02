package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Model.User;
import com.example.smartbudget.Request.RegisterRequest;
import com.example.smartbudget.Response.RegisterResponse;

public class RegisterHandler extends Handler<RegisterRequest, RegisterResponse> {
    @Override
    protected RegisterResponse handle(RegisterRequest request) {
        UserDao dao = DatabaseSqlManager.getInstance().createUserDao();
        User newUser = new User(request.getUsername(), request.getPassword());
        dao.createUser(newUser);
        return new RegisterResponse(true, newUser, "Sucess!");
    }

    @Override
    protected RegisterResponse fail(Exception e) {
        return new RegisterResponse(false, e.getMessage());
    }
}
