package com.example.smartbudget;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Model.User;

import java.util.UUID;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private DatabaseSqlManager manager;
    @Before
    public void setUp(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DatabaseSqlManager.setCurrContext(appContext);
        manager = DatabaseSqlManager.init("test.sqlite");
        manager.dropTables();
        manager.createTables();
    }
    @Test
    public void userDao() {
        // Context of the app under test.
        UserDao dao = manager.createUserDao();
        UUID id = UUID.randomUUID();
        User user = new User(id, "jimmy", "johns");
        assertNotNull(dao);
        try {
            dao.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        assertEquals(user.getId(), dao.getUser(user.getUsername(), user.getPassword()).getId());
    }
}