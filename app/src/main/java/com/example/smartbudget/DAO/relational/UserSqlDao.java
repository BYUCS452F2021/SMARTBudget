package com.example.smartbudget.DAO.relational;

import android.database.Cursor;

import com.example.smartbudget.DAO.StatementExecutor;
import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.User;

import java.util.UUID;

public class UserSqlDao extends SqlDao implements UserDao {

    public UserSqlDao(StatementExecutor executor) {
        super(executor);
    }

    @Override
    public String getTableStatement() {
        //User(UserID, Username, UserPassword)
        return "user_id TEXT PRIMARY KEY,\n" +
                "user_name TEXT NOT NULL UNIQUE,\n" +
                "user_password TEXT NOT NULL";
    }

    @Override
    protected String getTableName() {
        return "user";
    }

    @Override
    public void createUser(User user) {
        //insert into user (user_id, user_name, user_password) values ('','','',);
        String sql = "INSERT INTO " + getTableName() + " (user_id, user_name, user_password)" +
                " VALUES ('" + user.getId() + "','" + user.getUsername() + "','" + user.getPassword() +
                "');";
        try {
            insert(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public User getUser(String username, String passwordAttempt) {
        String sql = "SELECT * FROM user WHERE user_name=\'" + username + "\' AND user_password=\'" + passwordAttempt + "\';";
        Cursor cursor = (Cursor) executor.executeQuery(sql);
        cursor.moveToNext();
        String id = cursor.getString(0);
        String name = cursor.getString(1);
        String password = cursor.getString(2);
        return new User(UUID.fromString(id), name, password);
    }
}
