package dao.inter;

import entitiy.Skill;

import java.util.List;

public interface SkillDaoInter {
    public List<Skill> getAll();
    public int insertSkill(Skill skill);
    public void deleteSkill(int id);
}
