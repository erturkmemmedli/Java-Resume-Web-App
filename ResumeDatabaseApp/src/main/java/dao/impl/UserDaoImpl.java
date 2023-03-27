package dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import dao.inter.AbstractDao;
import dao.inter.UserDaoInter;
import entitiy.Country;
import entitiy.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {
    private User getUser(ResultSet resultSet) throws Exception {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String profileDescription = resultSet.getString("profile_description");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        Date birthday = resultSet.getDate("birthday");
        String address = resultSet.getString("address");
        Integer countryId = resultSet.getInt("country_id");
        String countryName = resultSet.getString("country");
        String nationalityName = resultSet.getString("nationality");
        Country country = new Country(countryId, countryName, nationalityName);
        return new User(id, name, surname, profileDescription, address, email, phone, birthday, country);
    }

    private User getUserSimple(ResultSet resultSet) throws Exception {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String profileDescription = resultSet.getString("profile_description");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        Date birthday = resultSet.getDate("birthday");
        String address = resultSet.getString("address");
        Integer countryId = resultSet.getInt("country_id");
        User user = new User(id, name, surname, profileDescription, address, email, phone, birthday, null);
        user.setPassword(resultSet.getString("password"));
        return user;
    }

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
                User u = getUser(resultSet);
                list.add(u);
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
                User u = getUser(resultSet);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " +
                    "u.*, c.name as country, c.nationality " +
                    "from user u " +
                    "left join country c on u.country_id = c.id " +
                    "where u.id = " + userId);
            while (resultSet.next()) {
                result = getUser(resultSet);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection connection = connect()) {
            PreparedStatement setForeignKeyChecks = connection.prepareStatement("set foreign_key_checks = 0");
            setForeignKeyChecks.execute();
            PreparedStatement statement = connection.prepareStatement("update user " +
                    "set name = ?, surname = ?, email = ?, phone = ?, profile_description = ?," +
                    "birthday = ?, address = ?, country_id = ? where id = ?");
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setString(3, u.getEmail());
            statement.setString(4, u.getPhone());
            statement.setString(5, u.getProfileDescription());
            statement.setDate(6, u.getBirthday());
            statement.setString(7, u.getAddress());
            statement.setInt(8, u.getCountry().getId());
            statement.setInt(9, u.getId());
            return statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            return statement.execute("delete from user where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("insert " +
                    "into user(name, surname, email, phone, password) " +
                    "values (?, ?, ? ,?, ?)");
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setString(3, u.getEmail());
            statement.setString(4, u.getPhone());
            statement.setString(5, crypt.hashToString(4, u.getPassword().toCharArray()));
            return statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
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
                user = getUserSimple(resultSet);
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
                user = getUserSimple(resultSet);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
}