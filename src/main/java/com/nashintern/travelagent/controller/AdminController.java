package com.nashintern.travelagent.controller;


import com.nashintern.travelagent.model.User;
import com.nashintern.travelagent.repository.UserRepository;
import com.nashintern.travelagent.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@ComponentScan
public class AdminController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private CustomUserDetailsService service;

    @GetMapping("/listUsers")
    public String viewUserList(Model model){
        List<User> listUsers = repository.findAll();
        model.addAttribute("listUsers", listUsers);
        return "list_users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        User user = service.get(id);
        model.addAttribute("user", user);
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        service.save(user);

        return "redirect:/users";
    }
}
