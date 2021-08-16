package com.example.springApp.controller;

import com.example.springApp.domain.*;
import com.example.springApp.repos.ActivityRepo;
import com.example.springApp.repos.UserActivityRepo;
import com.example.springApp.repos.UserActivityTimeRepo;
import com.example.springApp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private UserActivityRepo userActivityRepo;

    @Autowired
    private UserActivityTimeRepo userActivityTimeRepo;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("usersActivities", userActivityRepo.findAll());
        model.addAttribute("usersActivitiesTime", userActivityTimeRepo.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("userToEdit", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("activities", activityRepo.findAll());
        model.addAttribute("usersActivities", userActivityRepo.findAll());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user,
            @RequestParam("newActivityStatus") String newActivityStatus
    ) {
        System.out.println(username);
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.setRole(Role.valueOf(key));
            }
        }

        for (String key : form.keySet()) {
            Activity byActivityname = activityRepo.findByActivityname(key);
            if (byActivityname != null) {
                byActivityname.increaseCounter();
                activityRepo.save(byActivityname);
                userActivityRepo.save
                        (new UserActivity(user, byActivityname, Status.valueOf(newActivityStatus)));
            }
        }
        userRepo.save(user);
        return "redirect:/user";
    }
}