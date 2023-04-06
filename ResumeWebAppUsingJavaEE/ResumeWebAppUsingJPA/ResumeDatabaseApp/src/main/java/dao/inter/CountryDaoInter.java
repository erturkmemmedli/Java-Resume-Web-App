package dao.inter;

import entity.Country;

import java.util.List;

public interface CountryDaoInter {
    List<Country> getAll();
    Country getById(int id);
    boolean addCountry(Country country);
    boolean removeCountry(int id);
    boolean updateCountry(Country country);
}