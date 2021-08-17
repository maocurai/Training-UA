package com.example.springApp.controller;

import com.example.springApp.domain.Role;
import com.example.springApp.domain.User;
import com.example.springApp.service.ActivityService;
import com.example.springApp.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping("{user}")
    public String userActivityPage(@PathVariable User user,
                               Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("activities", activityService.findAll());
        model.addAttribute("usersActivities", userActivityService.findByUserId(user.getId()));
        return "adminActivity";
    }




}
