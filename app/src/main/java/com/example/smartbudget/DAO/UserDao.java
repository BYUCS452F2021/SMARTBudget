package com.example.smartbudget.DAO;

import com.example.smartbudget.DAO.relational.SqlDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Model.User;

public interface UserDao {
    boolean createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(String id);
    User getUser(String username);
}
