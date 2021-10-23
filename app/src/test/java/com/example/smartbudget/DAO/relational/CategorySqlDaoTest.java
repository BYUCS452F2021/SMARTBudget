package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.DaoFactory;
import com.example.smartbudget.DAO.SqlDaoTest;
import com.example.smartbudget.Model.Category;

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
    void createCategoryTest() {
        Category category = new Category("food", (float) 100.5);
        assertTrue(dao.createCategory(category));
    }

    @Test
    void myTest(){

        assertTrue(true);
    }

}