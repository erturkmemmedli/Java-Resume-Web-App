package main;

import dao.impl.*;
import dao.inter.*;

public class Context {
    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceUserSkillDao() {
        return new UserSkillDaoImpl();
    }

    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao() {
        return new EmploymentHistoryDaoImpl();
    }
    
    public static UserEmploymentHistoryDaoInter instanceUserEmploymentHistoryDao() {
        return new UserEmploymentHistoryDaoImpl();
    }

    public static CountryDaoInter instanceCountryDao() {
        return new CountryDaoImpl();
    }

    public static SkillDaoInter instanceSkillDao() {
        return new SkillDaoImpl();
    }
}