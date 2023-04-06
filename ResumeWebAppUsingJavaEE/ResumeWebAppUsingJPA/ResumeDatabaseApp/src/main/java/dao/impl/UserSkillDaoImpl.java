package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.UserSkillDaoInter;
import entity.UserSkill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {
    @Override
    public List<UserSkill> getAll() {
        EntityManager entityManager = entityManager();

        String jpql = "select u from UserSkill u";
        Query query = entityManager.createQuery(jpql, UserSkill.class);

        return query.getResultList();
    }

    @Override
    public UserSkill getById(int id) {
        EntityManager entityManager = entityManager();

        UserSkill userSkill = entityManager.find(UserSkill.class, id);

        entityManager.close();
        return userSkill;
    }

    @Override
    public List<UserSkill> getAllByUserId(int id) {
        EntityManager entityManager = entityManager();

        String jpql = "select e from UserSkill e where userId =: id";
        Query query = entityManager.createQuery(jpql, UserSkill.class);
        query.setParameter("id", id);

        return query.getResultList();
    }

    @Override
    public boolean removeUserSkill(int id) {
        EntityManager entityManager = entityManager();

        UserSkill userSkill = entityManager.find(UserSkill.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(userSkill);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }

    @Override
    public boolean addUserSkill(UserSkill userSkill) {
        EntityManager entityManager = entityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(userSkill);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        EntityManager entityManager = entityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(userSkill);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }
}