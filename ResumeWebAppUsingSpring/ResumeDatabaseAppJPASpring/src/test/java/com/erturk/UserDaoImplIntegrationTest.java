package com.erturk;

import com.erturk.dao.impl.UserDaoImpl;
import com.erturk.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest // Get configuration parameters from test/resources/application.properties
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserDaoImplIntegrationTest {
    @Autowired
    UserDaoImpl userDao;

    /*
    @Before
    public void before() {
        // You must be sure that you are not connected to real database in production.
        // Assume there is deleteAll method that deletes all users.
        userDao.deleteAll();
        // Assume you add new users for test environment.
        userDao.addUser(new User());
        userDao.addUser(new User());
    }
    */

    @Test
    public void testGetAll() {
        List<User> users = userDao.getAll();

        Assert.assertEquals("Number of users must be 12", 12, users.size());
    }
}
