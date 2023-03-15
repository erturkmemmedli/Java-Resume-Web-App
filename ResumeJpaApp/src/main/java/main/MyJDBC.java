package main;

import dao.inter.UserDaoInter;

public class MyJDBC {
    public static void main(String[] args) {
        UserDaoInter dao = Context.instanceUserDao();
    }
}