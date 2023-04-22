package com.erturk.dto;

import com.erturk.entity.User;
import com.erturk.entity.UserSkill;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String password;
    private List<UserSkillDTO> skills;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();

        List<UserSkill> userSkills = (List<UserSkill>) user.getUserSkillsById();
        List<UserSkillDTO> list = new ArrayList<>();

        for (int i = 0; i < userSkills.size(); i++) {
            list.add(new UserSkillDTO(userSkills.get(i)));
        }

        this.skills = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<UserSkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkillDTO> skills) {
        this.skills = skills;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
