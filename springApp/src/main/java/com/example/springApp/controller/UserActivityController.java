package com.example.springApp.controller;

import com.example.springApp.domain.Role;
import com.example.springApp.domain.User;
import com.example.springApp.repos.ActivityRepo;
import com.example.springApp.repos.UserActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserActivityController {

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private UserActivityRepo userActivityRepo;

    @GetMapping("{user}")
    public String userActivityPage(@PathVariable User user,
                               Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("activities", activityRepo.findAll());
        model.addAttribute("usersActivities", userActivityRepo.findByuserId(user.getId()));
        return "adminActivity";
    }




}
