package com.erturk.dao.inter;

import com.erturk.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    List<UserSkill> getAll();
    UserSkill getById(int id);
    List<UserSkill> getAllByUserId(int id);
    boolean removeUserSkill(int id);
    boolean addUserSkill(UserSkill userSkill);
    boolean updateUserSkill(UserSkill userSkill);
}