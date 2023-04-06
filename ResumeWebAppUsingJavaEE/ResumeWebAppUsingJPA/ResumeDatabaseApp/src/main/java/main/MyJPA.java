package main;

import dao.inter.UserDaoInter;

public class MyJPA {
    public static void main(String[] args) {
        System.out.println("Implementation classes created by using JPA are tested here!");
        UserDaoInter dao = Context.instanceUserDao();
    }
}