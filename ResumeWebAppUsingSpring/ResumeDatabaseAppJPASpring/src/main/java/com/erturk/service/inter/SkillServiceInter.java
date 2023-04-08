package com.erturk.service.inter;

import com.erturk.entity.Skill;

import java.util.List;

public interface SkillServiceInter {
    List<Skill> getAll();
    Skill getById(int id);
    boolean addSkill(Skill skill);
    boolean removeSkill(int id);
    boolean updateSkill(Skill skill);
}