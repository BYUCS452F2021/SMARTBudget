package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Model.User;
import com.example.smartbudget.Request.LoginRequest;
import com.example.smartbudget.Response.LoginResponse;

public class LoginHandler extends Handler<LoginRequest, LoginResponse> {
    @Override
    protected LoginResponse handle(LoginRequest request) {
        UserDao dao = DatabaseSqlManager.getInstance().createUserDao();
        User userToBeLoggedIn = dao.getUser(request.getUsername(), request.getPassword());
        return new LoginResponse(true, userToBeLoggedIn);
    }

    @Override
    protected LoginResponse fail(Exception e) {
        return new LoginResponse(false, e.getMessage());
    }
}
