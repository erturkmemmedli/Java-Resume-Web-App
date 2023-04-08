package com.erturk.dao.impl;

import com.erturk.dao.inter.UserSkillDaoInter;
import com.erturk.entity.UserSkill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("userSkillDao")
public class UserSkillDaoImpl implements UserSkillDaoInter {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserSkill> getAll() {
        String jpql = "select u from UserSkill u";
        Query query = entityManager.createQuery(jpql, UserSkill.class);
        return query.getResultList();
    }

    @Override
    public UserSkill getById(int id) {
        UserSkill userSkill = entityManager.find(UserSkill.class, id);
        return userSkill;
    }

    @Override
    public List<UserSkill> getAllByUserId(int id) {
        String jpql = "select e from UserSkill e where userId =: id";
        Query query = entityManager.createQuery(jpql, UserSkill.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public boolean removeUserSkill(int id) {
        UserSkill userSkill = entityManager.find(UserSkill.class, id);
        entityManager.remove(userSkill);
        return true;
    }

    @Override
    public boolean addUserSkill(UserSkill userSkill) {
        entityManager.persist(userSkill);
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        entityManager.merge(userSkill);
        return true;
    }
}