package com.erturk.service.impl;

import com.erturk.dao.inter.EmploymentHistoryDaoInter;
import com.erturk.service.inter.EmploymentHistoryServiceInter;
import com.erturk.entity.EmploymentHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employmentHistoryService")
@Transactional
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {
    @Autowired
    @Qualifier("employmentHistoryDao")
    private EmploymentHistoryDaoInter employmentHistoryDao;

    @Override
    public List<EmploymentHistory> getAll() {
        return employmentHistoryDao.getAll();
    }

    @Override
    public EmploymentHistory getById(int id) {
        return employmentHistoryDao.getById(id);
    }

    @Override
    public List<EmploymentHistory> getAllByUserId(int id) {
        return employmentHistoryDao.getAllByUserId(id);
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        return employmentHistoryDao.updateEmploymentHistory(employmentHistory);
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory employmentHistory) {
        return employmentHistoryDao.addEmploymentHistory(employmentHistory);
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        return employmentHistoryDao.removeEmploymentHistory(id);
    }
}
