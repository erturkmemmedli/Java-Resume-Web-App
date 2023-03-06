package dao.inter;

import entitiy.EmploymentHistory;

import java.util.List;

public interface UserEmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int id);
    }
