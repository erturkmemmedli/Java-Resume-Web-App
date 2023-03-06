package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.CountryDaoInter;
import entitiy.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {
    @Override
    public List<Country> getCountryAndNationality() {
        List<Country> list = new ArrayList<>();
        try(Connection connection = connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from country");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String birthplace = resultSet.getString("name");
                String nationality =  resultSet.getString("nationality");
                list.add(new Country(id, birthplace, nationality));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
