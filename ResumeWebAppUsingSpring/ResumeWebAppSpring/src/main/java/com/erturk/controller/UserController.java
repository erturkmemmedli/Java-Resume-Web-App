package com.erturk.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.erturk.entity.User;
import com.erturk.form.UserForm;
import com.erturk.service.DummyService;
import com.erturk.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    public UserServiceInter userService;

    @ModelAttribute("user")
    public UserForm getEmptyUserForm() {
        return new UserForm();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users1")
    public String index1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String countryIdStr = request.getParameter("nationalityId");
        Integer countryId = null;

        if (countryIdStr != null && !countryIdStr.trim().isEmpty()) {
            countryId = Integer.parseInt(countryIdStr);
        }

        List<User> users = userService.getAllByFilter(name, surname, countryId);
        request.setAttribute("users", users);
        return "usersJava";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users2")
    public ModelAndView index2(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "surname", required = false) String surname,
                               @RequestParam(value = "nationalityId", required = false) Integer countryId) {
        List<User> users = userService.getAllByFilter(name, surname, countryId);
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView index(@Valid @ModelAttribute("user") UserForm uf, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("users");

        if (bindingResult.hasErrors()) {
            return mv;
        }

        List<User> users = userService.getAllByFilter(uf.getName(), uf.getSurname(), uf.getCountryId());
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public ModelAndView getRegister() {
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ModelAndView postRegister(@ModelAttribute("user") UserForm uf) {
        User user = new User();

        user.setName(uf.getName());
        user.setSurname(uf.getSurname());
        String bcryptHashString = BCrypt.withDefaults().hashToString(4, uf.getPassword().toCharArray());
        user.setPassword(bcryptHashString);
        user.setPhone(uf.getPhone());
        user.setEmail(uf.getEmail());
        userService.addUser(user);

        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/loginCustom")
    public String login(){
        return "loginCustom";
    }

    @GetMapping("/logoutCustom")
    public String logoutPage(){
        return "loginCustom";
    }

    @Autowired
    DummyService dummyService;

    @RequestMapping(method = {RequestMethod.GET}, value="/foo")
    public String foo() {
        System.out.println("foo in Controller");
        dummyService.foo();
        return "users";
    }
}