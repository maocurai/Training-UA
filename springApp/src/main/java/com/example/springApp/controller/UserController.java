package com.example.springApp.controller;

import com.example.springApp.domain.*;
import com.example.springApp.repos.ActivityRepo;
import com.example.springApp.repos.UserActivityRepo;
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

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        System.out.println(userActivityRepo.findAll().size());
        model.addAttribute("usersActivities", userActivityRepo.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("activities", activityRepo.findAll());
        model.addAttribute("usersActivities", userActivityRepo.findAll());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
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
//                user.addUserActivity(
                        userActivityRepo.save
                        (new UserActivity(user, activityRepo.findByActivityname(key), false));
//                );
            }
        }
//        for(UserActivity ua : user.getUserActivitySet()) {
//            System.out.println(ua.getActivity().getActivityname());
//        }
        userRepo.save(user);
        return "redirect:/user";
    }
}