package com.example.smartbudget.DAO;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.DAO.relational.SqlDaoFactory;
import com.example.smartbudget.DAO.relational.SqlDatabase;
import com.example.smartbudget.Exceptions.DataAccessException;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class SqlDaoTest {
    protected static DatabaseSqlManager manager;
    protected static String DB_PATH = "test.sqlite";

    @BeforeAll
    protected static void start(){
        try {
            manager = new DatabaseSqlManager(DB_PATH);
        } catch (DataAccessException e) {
            e.printStackTrace();
            fail();
        }
    }

    @AfterAll
    protected static void stop(){
        try {
            manager.dropTables();
        } catch (DataAccessException e) {
            e.printStackTrace();
            fail();
        }
    }

    @BeforeEach
    protected void setUp(){
        try {
            manager.clearTables();
        } catch (DataAccessException e) {
            e.printStackTrace();
            fail();
        }
    }

    @AfterEach
    protected void tearDown(){
        try {
            manager.clearTables();
        } catch (DataAccessException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @DisplayName("Testing my patience")
    public void testGuy(){
        assertTrue(true);
    }
}