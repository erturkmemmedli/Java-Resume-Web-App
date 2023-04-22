package com.erturk.dto;

import com.erturk.entity.User;
import com.erturk.entity.UserSkill;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private List<UserSkillDTO> skills;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String surname, String email, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.phone = user.getPhone();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
