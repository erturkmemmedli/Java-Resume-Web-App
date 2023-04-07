package com.erturk.dao.impl;

import com.erturk.dao.inter.EmploymentHistoryDaoInter;
import com.erturk.entity.EmploymentHistory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmploymentHistoryDaoImpl implements EmploymentHistoryDaoInter {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<EmploymentHistory> getAll() {
        String jpql = "select e from EmploymentHistory e";
        Query query = entityManager.createQuery(jpql, EmploymentHistory.class);
        return query.getResultList();
    }

    @Override
    public EmploymentHistory getById(int id) {
        EmploymentHistory employmentHistory = entityManager.find(EmploymentHistory.class, id);
        return employmentHistory;
    }

    @Override
    public List<EmploymentHistory> getAllByUserId(int id) {
        String jpql = "select e from EmploymentHistory e where userId =: id";
        Query query = entityManager.createQuery(jpql, EmploymentHistory.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        entityManager.merge(employmentHistory);
        return true;
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory employmentHistory) {
        entityManager.persist(employmentHistory);
        return true;
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        EmploymentHistory employmentHistory = entityManager.find(EmploymentHistory.class, id);
        entityManager.remove(employmentHistory);
        return true;
    }
}
