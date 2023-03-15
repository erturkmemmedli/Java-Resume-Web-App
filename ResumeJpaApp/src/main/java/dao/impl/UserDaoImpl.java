package dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import dao.inter.AbstractDao;
import dao.inter.UserDaoInter;
import entity.User;

import javax.persistence.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {
    private BCrypt.Hasher crypt = BCrypt.withDefaults();
    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " +
                    "u.*, c.name as country, c.nationality " +
                    "from user u " +
                    "left join country c on u.country_id = c.id");
            while (resultSet.next()) {
                //User u = getUser(resultSet);
                //list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public List<User> getAllByNameSurnameNationality(String name, String surname, Integer countryId) {
        List<User> list = new ArrayList<>();
        try (Connection connection = connect()) {
            String sql = "select " +
                    "u.*, c.name as country, " +
                    "c.nationality " +
                    "from user u " +
                    "left join country c " +
                    "on u.country_id = c.id " +
                    "where 1=1";
            if (name != null && !name.trim().isEmpty()) {
                sql += " and u.name = ?";
            }
            if (surname != null && !surname.trim().isEmpty()) {
                sql += " and u.surname = ?";
            }
            if (countryId != null) {
                sql += " and u.countryId = ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            int i = 1;
            if (name != null && !name.trim().isEmpty()) {
                statement.setString(i, name);
                i++;
            }
            if (surname != null && !surname.trim().isEmpty()) {
                statement.setString(i, surname);
                i++;
            }
            if (countryId != null) {
                statement.setInt(i, countryId);
            }
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                //User u = getUser(resultSet);
                //list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    @Override
    public User getById(int userId) {
        EntityManager entityManager = entityManager();

        User user = entityManager.find(User.class, userId);

        entityManager.close();
        return user;
    }
    @Override
    public boolean updateUser(User user) {
        user.setPassword(crypt.hashToString(4, user.getPassword().toCharArray()));

        EntityManager entityManager = entityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }
    @Override
    public boolean removeUser(int id) {
        EntityManager entityManager = entityManager();

        User user = entityManager.find(User.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }
    @Override
    public boolean addUser(User user) {
        user.setPassword(crypt.hashToString(4, user.getPassword().toCharArray()));

        EntityManager entityManager = entityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }
    public User findByEmailAndPassword(String email, String password) {
        User user = null;
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("select * " +
                    "from user where email=? and password=?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //user = getUserSimple(resultSet);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
    public User findByEmail(String email) {
        User user = null;
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("select * from user where email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //user = getUserSimple(resultSet);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
}