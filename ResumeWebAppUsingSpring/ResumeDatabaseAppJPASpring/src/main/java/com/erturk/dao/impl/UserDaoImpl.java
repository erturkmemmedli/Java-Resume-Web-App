package com.erturk.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.erturk.dao.inter.UserDaoInter;
import com.erturk.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl implements UserDaoInter {
    @PersistenceContext
    EntityManager entityManager;

    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public List<User> getAll() {
        String jpql = "select u from User u";
        Query query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public List<User> getAllByFilter(String name, String surname, Integer countryId) {
        String jpql = "select u from User u where 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name = :name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname = :surname";
        }
        if (countryId != null) {
            jpql += " and u.country.id = :cid";
        }
        Query query = entityManager.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (countryId != null) {
            query.setParameter("cid", countryId);
        }
        return query.getResultList();
    }

    @Override
    public User getById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        user.setPassword(crypt.hashToString(4, user.getPassword().toCharArray()));
        entityManager.merge(user);
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        return true;
    }

    @Override
    public boolean addUser(User user) {
        user.setPassword(crypt.hashToString(4, user.getPassword().toCharArray()));
        entityManager.persist(user);
        return true;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        Query query = entityManager.createQuery("select u from User u where u.email=:e and u.password=:p", User.class);
        query.setParameter("e", email);
        query.setParameter("p", password);
        List<User> list = query.getResultList();
        if (list.size() == 1 ) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        Query query = entityManager.createQuery("select u from User u where u.email=:e", User.class);
        query.setParameter("e", email);
        List<User> list = query.getResultList();
        if (list.size() == 1 ) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User findByEmailCriteriaBuilder(String email) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("email"), email));
        Query query = entityManager.createQuery(criteriaQuery);
        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User findByEmailNamedQuery(String email) {
        Query query = entityManager.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email", email);
        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}