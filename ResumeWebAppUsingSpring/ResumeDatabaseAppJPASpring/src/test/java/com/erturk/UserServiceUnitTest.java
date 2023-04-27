package com.erturk;

import com.erturk.dao.inter.UserDaoInter;
import com.erturk.entity.User;
import com.erturk.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

public class UserServiceUnitTest {
    @Mock
    UserDaoInter userDao;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeClass
    public static void setUp() {
        System.out.println("Set up has been called.");
    }

    @Before
    public void before() {
        System.out.println("Before has been called.");

        MockitoAnnotations.initMocks(this);

        List<User> users = new ArrayList<>();
        User user = new User();

        user.setName("test");
        user.setSurname("test");
        user.setEmail("test@test.com");
        user.setCountryId(1);

        users.add(user);

        Mockito.when(userDao.getAllByFilter(null, null, null)).thenReturn(users);

        Mockito.when(userDao.getAllByFilter("test", "test", 1)).thenReturn(users);

        Mockito.when(userDao.findByEmailAndPassword(null, null)).thenReturn(null);
    }

    @Test
    public void showReturnAllParameters_whenGivenNoParameter() {
        List<User> users = userService.getAllByFilter(null, null, null);

        Assert.assertEquals("Number of users must be 1.", 1, users.size());

        Mockito.verify(userDao, Mockito.atLeastOnce()).getAllByFilter(null, null, null);
    }

    @Test
    public void showReturnAllParameters_whenGivenParametersByFilter() {
        List<User> users = userService.getAllByFilter("test", "test", 1);

        Assert.assertTrue("User size must be greater than 0.", users.size() > 0);

        User user = users.get(0);

        Assert.assertEquals("Name is wrong.", "test", user.getName());
        Assert.assertEquals("Surname is wrong.", "test", user.getSurname());
        Assert.assertEquals("Country ID is wrong.", 1L, (long) user.getCountryId());

        Mockito.verify(userDao, Mockito.atLeastOnce()).getAllByFilter("test", "test", 1);
    }

    @Test
    public void showReturnNull_whenGivenNullEmailAndPassword() {
        User user = userService.findByEmailAndPassword(null, null);

        Assert.assertNull("User must be null.", user);

        Mockito.verify(userDao, Mockito.atLeastOnce()).findByEmailAndPassword(null, null);
    }
}
