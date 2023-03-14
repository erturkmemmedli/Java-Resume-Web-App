package main;

import dao.inter.UserDaoInter;
import entitiy.User;

public class MyJDBC {
    public static void main(String[] args) {
        UserDaoInter u = Context.instanceUserDao();
        User x = new User("a","b","x@email.com","b");
        x.setPassword("12345");
        u.addUser(x);
    }
}