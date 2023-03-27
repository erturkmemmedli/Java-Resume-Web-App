package dao.inter;

import entity.User;

import java.util.List;

public interface UserDaoInter {
    List<User> getAll(String name, String surname, Integer countryId);
    public User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    public User findByEmailCriteriaBuilder(String email);
    public User findByEmailNamedQuery(String email);
    User getById(int id);
    boolean updateUser(User u);
    boolean removeUser(int id);
    boolean addUser(User u);
}
