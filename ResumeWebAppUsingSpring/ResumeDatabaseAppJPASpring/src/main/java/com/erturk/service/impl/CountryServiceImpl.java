package com.erturk.service.impl;

import com.erturk.dao.inter.CountryDaoInter;
import com.erturk.entity.Country;
import com.erturk.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryServiceInter {
    @Autowired
    @Qualifier("countryDao")
    private CountryDaoInter countryDao;

    @Override
    public List<Country> getAll() {
        return countryDao.getAll();
    }

    @Override
    public Country getById(int id) {
        return countryDao.getById(id);
    }

    @Override
    public boolean addCountry(Country country) {
        return countryDao.addCountry(country);
    }

    @Override
    public boolean removeCountry(int id) {
        return countryDao.removeCountry(id);
    }

    @Override
    public boolean updateCountry(Country country) {
        return countryDao.updateCountry(country);
    }
}