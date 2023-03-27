package main;

import dao.inter.UserDaoInter;
import entity.User;

public class MyJDBC {
    public static void main(String[] args) {
        UserDaoInter dao = Context.instanceUserDao();

        System.out.println(dao.findByEmailNamedQuery("erturk@yahoo.com").getName());
    }
}