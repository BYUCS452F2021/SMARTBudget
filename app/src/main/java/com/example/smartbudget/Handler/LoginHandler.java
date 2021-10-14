package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.DaoFactory;
import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.DAO.relational.UserSqlDao;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.User;
import com.example.smartbudget.Request.LoginRequest;
import com.example.smartbudget.Response.LoginResponse;

public class LoginHandler {

    public LoginResponse login(LoginRequest request){
        DaoFactory manager = DatabaseSqlManager.getInstance();
        UserDao userDao = manager.createUserDao();
        //query userdao to determine if login succeed
        User user = userDao.getUser(request.getUsername());
        if(user != null){
            return new LoginResponse(true, user, null);
        }
        return new LoginResponse(false, null, "Data access returned no user");
    }
}
