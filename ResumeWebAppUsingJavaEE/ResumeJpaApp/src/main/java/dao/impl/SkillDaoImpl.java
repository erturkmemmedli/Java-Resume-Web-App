package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.SkillDaoInter;
import entity.Skill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {
    @Override
    public List<Skill> getAll() {
        EntityManager entityManager = entityManager();

        String jpql = "select s from Skill s";
        Query query = entityManager.createQuery(jpql, Skill.class);

        return query.getResultList();
    }

    @Override
    public Skill getById(int id) {
        EntityManager entityManager = entityManager();

        Skill skill = entityManager.find(Skill.class, id);

        entityManager.close();
        return skill;
    }

    @Override
    public boolean addSkill(Skill skill) {
        EntityManager entityManager = entityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(skill);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        EntityManager entityManager = entityManager();

        Skill skill = entityManager.find(Skill.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(skill);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        EntityManager entityManager = entityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(skill);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }
}
