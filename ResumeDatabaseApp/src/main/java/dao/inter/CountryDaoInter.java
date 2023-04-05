package dao.inter;

import entity.Country;

import java.util.List;

public interface CountryDaoInter {
    public List<Country> getCountryAndNationality();
    public Country getById(int id);
}
