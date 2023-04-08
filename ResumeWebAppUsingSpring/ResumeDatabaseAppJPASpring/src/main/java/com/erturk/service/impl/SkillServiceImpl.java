package com.erturk.service.impl;

import com.erturk.dao.inter.SkillDaoInter;
import com.erturk.service.inter.SkillServiceInter;
import com.erturk.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("skillService")
@Transactional
public class SkillServiceImpl implements SkillServiceInter {
    @Autowired
    @Qualifier("skillDao")
    private SkillDaoInter skillDao;

    @Override
    public List<Skill> getAll() {
        return skillDao.getAll();
    }

    @Override
    public Skill getById(int id) {
        return skillDao.getById(id);
    }

    @Override
    public boolean addSkill(Skill skill) {
        return skillDao.addSkill(skill);
    }

    @Override
    public boolean removeSkill(int id) {
        return skillDao.removeSkill(id);
    }

    @Override
    public boolean updateSkill(Skill skill) {
        return skillDao.updateSkill(skill);
    }
}