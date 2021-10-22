package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.DaoFactory;
import com.example.smartbudget.DAO.SqlDaoTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategorySqlDaoTest extends SqlDaoTest {
    private CategoryDao dao;
    @BeforeEach
    void categorySetUp() {
        DaoFactory factory = new SqlDaoFactory(DB_PATH);
        dao = factory.createCategoryDao();
    }

    @Test
    void myTest(){
        assertTrue(true);
    }

}