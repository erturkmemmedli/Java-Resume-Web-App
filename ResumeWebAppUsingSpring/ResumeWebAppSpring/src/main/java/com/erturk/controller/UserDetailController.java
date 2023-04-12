package com.erturk.controller;

import com.erturk.entity.User;
import com.erturk.form.UserForm;
import com.erturk.service.inter.EmploymentHistoryServiceInter;
import com.erturk.service.inter.UserServiceInter;
import com.erturk.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserDetailController {
    @Autowired
    private UserServiceInter userService;

    @Autowired
    private UserSkillServiceInter userSkillService;

    @Autowired
    private EmploymentHistoryServiceInter employmentHistoryService;

    @ModelAttribute("user")
    public UserForm getEmptyUserForm() {
        return new UserForm();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/userdelete")
    public ModelAndView postDelete(@ModelAttribute("user") UserForm uf){
        userService.removeUser(uf.getId());

        List<User> users = userService.getAll();
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/userupdate")
    public ModelAndView postUpdate(@ModelAttribute("user") UserForm uf){
        User user = userService.getById(uf.getId());

        user.setName(uf.getName());
        user.setSurname(uf.getSurname());
        user.setProfileDescription(uf.getProfileDescription());
        user.setPhone(uf.getPhone());
        user.setEmail(uf.getEmail());
        userService.updateUser(user);

        List<User> users = userService.getAll();
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userupdate")
    public ModelAndView getUpdate(@ModelAttribute("user") UserForm uf) {
        User user = userService.getById(uf.getId());

        ModelAndView mv = new ModelAndView("userdetails");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userinfo")
    public ModelAndView getInfo(@ModelAttribute("user") UserForm uf) {
        User user = userService.getById(uf.getId());

        ModelAndView mv = new ModelAndView("userdetailsinfo");
        mv.addObject("user", user);
        return mv;
    }
}
