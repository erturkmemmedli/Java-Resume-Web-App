package com.erturk.dto;

import com.erturk.entity.UserSkill;

public class UserSkillDTO {
    private Integer userId;
    private Integer power;
    private SkillDTO skill;

    public UserSkillDTO() {
    }

    public UserSkillDTO(Integer userId, Integer power, SkillDTO skill) {
        this.userId = userId;
        this.power = power;
        this.skill = skill;
    }

    public UserSkillDTO(UserSkill userSkill) {
        this.userId = userSkill.getUserId();
        this.power = userSkill.getPower();
        this.skill = new SkillDTO(userSkill.getSkillBySkillId());
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public SkillDTO getSkill() {
        return skill;
    }

    public void setSkill(SkillDTO skill) {
        this.skill = skill;
    }
}
