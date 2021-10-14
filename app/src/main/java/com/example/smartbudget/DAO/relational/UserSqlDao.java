package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.User;

public class UserSqlDao extends SqlDao implements UserDao {

    public UserSqlDao(SqlStatementExecutor executor) {
        super(executor);
    }

    @Override
    public String getTableStatement() {
        //User(UserID, Username, UserPassword)
        return "user_id TEXT PRIMARY KEY,\n" +
                "user_name TEXT NOT NULL,\n" +
                "user_password TEXT NOT NULL";
    }

    @Override
    protected String getTableName() {
        return "user";
    }

    @Override
    public boolean createUser(User user) {
        //insert into user (user_id, user_name, user_password) values ('','','',);
        String sql = "INSERT INTO " + getTableName() + " (user_id, user_name, user_password)" +
                " VALUES ('" + user.getId() + "','" + user.getUsername() + "','" + user.getPassword() +
                "');";
        try {
            return insert(sql) > 0;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

    @Override
    public User getUser(String username) {
        return null;
    }
}
