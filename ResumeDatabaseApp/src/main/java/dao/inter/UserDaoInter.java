package dao.inter;

import entitiy.User;

import java.util.List;

public interface UserDaoInter {
    List<User> getAll();
    List<User> getAllByNameSurnameNationality(String name, String surname, Integer countryId);
    public User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    User getById(int id);
    boolean updateUser(User u);
    boolean removeUser(int id);
    boolean addUser(User u);
}
