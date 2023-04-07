package com.erturk.dao.inter;

import com.erturk.entity.Skill;

import java.util.List;

public interface SkillDaoInter {
    List<Skill> getAll();
    Skill getById(int id);
    boolean addSkill(Skill skill);
    boolean removeSkill(int id);
    boolean updateSkill(Skill skill);
}