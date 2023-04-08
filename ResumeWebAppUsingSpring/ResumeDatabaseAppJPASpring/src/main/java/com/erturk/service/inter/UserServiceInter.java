package com.erturk.service.inter;

import com.erturk.entity.User;

import java.util.List;

public interface UserServiceInter {
    List<User> getAll();
    List<User> getAllByFilter(String name, String surname, Integer countryId);
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    User getById(int id);
    boolean updateUser(User u);
    boolean removeUser(int id);
    boolean addUser(User u);
}