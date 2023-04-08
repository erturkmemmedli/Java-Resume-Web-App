package com.erturk.dao.impl;

import com.erturk.dao.inter.SkillDaoInter;
import com.erturk.entity.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("skillDao")
public class SkillDaoImpl implements SkillDaoInter {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Skill> getAll() {
        String jpql = "select s from Skill s";
        Query query = entityManager.createQuery(jpql, Skill.class);
        return query.getResultList();
    }

    @Override
    public Skill getById(int id) {
        Skill skill = entityManager.find(Skill.class, id);
        return skill;
    }

    @Override
    public boolean addSkill(Skill skill) {
        entityManager.persist(skill);
        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        Skill skill = entityManager.find(Skill.class, id);
        entityManager.remove(skill);
        return true;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        entityManager.merge(skill);
        return true;
    }
}