package entity;

import java.sql.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private String profileDescription;
    private String address;
    private String email;
    private String phone;
    private String password;
    private Date birthday;
    private Country country;
    private List<UserSkill> skills;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String surname,
                String profileDescription, String address,
                String email, String phone,
                Date birthday, Country country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.profileDescription = profileDescription;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.country = country;
    }

    public User(String name, String surname, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", profileDescription='" + profileDescription + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", country=" + country +
                ", skills=" + skills +
                '}';
    }
}
