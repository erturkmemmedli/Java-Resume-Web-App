package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.CountryDaoInter;
import entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    @Override
    public List<Country> getAll() {
        EntityManager entityManager = entityManager();

        String jpql = "select c from Country c";
        Query query = entityManager.createQuery(jpql, Country.class);

        return query.getResultList();
    }

    @Override
    public Country getById(int id) {
        EntityManager entityManager = entityManager();

        Country country = entityManager.find(Country.class, id);

        entityManager.close();
        return country;
    }

    @Override
    public boolean addCountry(Country country) {
        EntityManager entityManager = entityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        EntityManager entityManager = entityManager();

        Country country = entityManager.find(Country.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(country);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }

    @Override
    public boolean updateCountry(Country country) {
        EntityManager entityManager = entityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(country);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }
}
