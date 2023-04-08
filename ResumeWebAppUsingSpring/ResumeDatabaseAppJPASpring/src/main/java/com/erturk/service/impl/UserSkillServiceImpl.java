package com.erturk.service.impl;

import com.erturk.dao.inter.UserSkillDaoInter;
import com.erturk.service.inter.UserSkillServiceInter;
import com.erturk.entity.UserSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userSkillService")
@Transactional
public class UserSkillServiceImpl implements UserSkillServiceInter {
    @Autowired
    @Qualifier("userSkillDao")
    private UserSkillDaoInter userSkillDao;

    @Override
    public List<UserSkill> getAll() {
        return userSkillDao.getAll();
    }

    @Override
    public UserSkill getById(int id) {
        return userSkillDao.getById(id);
    }

    @Override
    public List<UserSkill> getAllByUserId(int id) {
        return userSkillDao.getAllByUserId(id);
    }

    @Override
    public boolean removeUserSkill(int id) {
        return userSkillDao.removeUserSkill(id);
    }

    @Override
    public boolean addUserSkill(UserSkill userSkill) {
        return userSkillDao.addUserSkill(userSkill);
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        return userSkillDao.updateUserSkill(userSkill);
    }
}