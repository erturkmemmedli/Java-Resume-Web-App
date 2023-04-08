package com.erturk.service.inter;

import com.erturk.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryServiceInter {
    List<EmploymentHistory> getAll();
    EmploymentHistory getById(int id);
    List<EmploymentHistory> getAllByUserId(int id);
    boolean updateEmploymentHistory(EmploymentHistory employmentHistory);
    boolean addEmploymentHistory(EmploymentHistory employmentHistory);
    boolean removeEmploymentHistory(int id);
}