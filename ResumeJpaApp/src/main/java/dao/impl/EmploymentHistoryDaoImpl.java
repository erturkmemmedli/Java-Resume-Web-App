package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.EmploymentHistoryDaoInter;
import entity.EmploymentHistory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {
    @Override
    public List<EmploymentHistory> getAll() {
        EntityManager entityManager = entityManager();

        String jpql = "select e from EmploymentHistory e";
        Query query = entityManager.createQuery(jpql, EmploymentHistory.class);

        return query.getResultList();
    }

    @Override
    public EmploymentHistory getById(int id) {
        EntityManager entityManager = entityManager();

        EmploymentHistory employmentHistory = entityManager.find(EmploymentHistory.class, id);

        entityManager.close();
        return employmentHistory;
    }

    @Override
    public List<EmploymentHistory> getAllByUserId(int id) {
        EntityManager entityManager = entityManager();

        String jpql = "select e from EmploymentHistory e where userId =: id";
        Query query = entityManager.createQuery(jpql, EmploymentHistory.class);
        query.setParameter("id", id);

        return query.getResultList();
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        EntityManager entityManager = entityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(employmentHistory);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory employmentHistory) {
        EntityManager entityManager = entityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(employmentHistory);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        EntityManager entityManager = entityManager();

        EmploymentHistory employmentHistory = entityManager.find(EmploymentHistory.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(employmentHistory);
        entityManager.getTransaction().commit();

        entityManager.close();
        return true;
    }
}
