package com.erturk.dao.inter;

import com.erturk.entity.Country;

import java.util.List;

public interface CountryDaoInter {
    List<Country> getAll();
    Country getById(int id);
    boolean addCountry(Country country);
    boolean removeCountry(int id);
    boolean updateCountry(Country country);
}