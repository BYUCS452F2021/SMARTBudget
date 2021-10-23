package com.example.smartbudget.DAO;

import com.example.smartbudget.DAO.relational.SqlDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Model.User;

public interface UserDao {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(String id);
    User getUser(String username, String password);
}
