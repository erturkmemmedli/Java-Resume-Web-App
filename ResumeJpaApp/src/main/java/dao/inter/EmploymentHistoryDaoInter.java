package dao.inter;

import entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryDaoInter {
    List<EmploymentHistory> getAll();
    EmploymentHistory getById(int id);
    List<EmploymentHistory> getAllByUserId(int id);
    boolean updateEmploymentHistory(EmploymentHistory employmentHistory);
    boolean addEmploymentHistory(EmploymentHistory employmentHistory);
    boolean removeEmploymentHistory(int id);
}
