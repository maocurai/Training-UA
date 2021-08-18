package com.example.springApp.controller;

import com.example.springApp.domain.*;
import com.example.springApp.service.ActivityService;
import com.example.springApp.service.UserActivityService;
import com.example.springApp.service.UserActivityTimeService;
import com.example.springApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserActivityService userActivityService;

    @Autowired
    private UserActivityTimeService userActivityTimeService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("usersActivities", userActivityService.findAll());
        model.addAttribute("usersActivitiesTime", userActivityTimeService.findAll());
        return
         "userList";
    }

    @GetMapping("/info/{user}")
    public String userMore(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("usersActivities", userActivityService.findByUserId(user.getId()));
        model.addAttribute("usersActivitiesTime", userActivityTimeService.findByUserId(user.getId()));
        return "userInfo";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("userToEdit", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("activities", activityService.findAll());
        model.addAttribute("NotUsersActivities", activityService.findByUserIdNotUsersActivities(user.getId()));
        model.addAttribute("usersActivities", userActivityService.findByUserId(user.getId()));
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user,
            @RequestParam("loggedUserId") String loggedUserId,
            @RequestParam("newActivityStatus") String newActivityStatus
    ) {
        user.setUsername(username);
        user = setActivities(form, setRole(form, user), newActivityStatus);
        userService.save(user);
        User currentUser = userService.findByUserId(Long.valueOf(loggedUserId));
        return currentUser.isAdmin() ? "redirect:/user" : ("redirect:/adminActivity/" + user.getId());
    }

    public User setActivities(Map<String, String> form, User user, String newActivityStatus) {
        for (String key : form.keySet()) {
            Activity byActivityname = activityService.findByName(key);
            if (byActivityname != null) {
                userActivityService.save
                        (new UserActivity(user, byActivityname, Status.valueOf(newActivityStatus)));
            }
        }
        return user;
    }

    public User setRole(Map<String, String> form, User user) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.setRole(Role.valueOf(key));
            }
        }
        return user;
    }
}