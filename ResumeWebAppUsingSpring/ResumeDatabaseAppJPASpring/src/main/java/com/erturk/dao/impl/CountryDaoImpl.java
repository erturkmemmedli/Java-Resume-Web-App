package com.erturk.dao.impl;

import com.erturk.dao.inter.CountryDaoInter;
import com.erturk.entity.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDaoInter {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Country> getAll() {
        String jpql = "select c from Country c";
        Query query = entityManager.createQuery(jpql, Country.class);
        return query.getResultList();
    }

    @Override
    public Country getById(int id) {
        Country country = entityManager.find(Country.class, id);
        return country;
    }

    @Override
    public boolean addCountry(Country country) {
        entityManager.persist(country);
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        Country country = entityManager.find(Country.class, id);
        entityManager.remove(country);
        return true;
    }

    @Override
    public boolean updateCountry(Country country) {
        entityManager.merge(country);
        return true;
    }
}