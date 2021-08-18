package com.example.springApp.controller;

import com.example.springApp.domain.*;
import com.example.springApp.repos.ActivityUsersCounter;
import com.example.springApp.repos.ActivityUsersCounterRepo;
import com.example.springApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adminActivity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserActivityService userActivityService;

    @Autowired
    private UserActivityTimeService userActivityTimeService;

    @Autowired
    private ActivityUsersCounterRepo activityUsersCounterRepo;


    @GetMapping("{user}")
    public String userActivityPage(@PathVariable User user,
                                   Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("activities", activityService.findAll());
        model.addAttribute("usersActivities", userActivityService.findByUserId(user.getId()));
        return "adminActivity";
    }

    public String changeSortingDirection(String currentOrderDirection) {
        return currentOrderDirection.equals("ASC") ? "DESC" : "ASC";
    }

    @GetMapping
    public String activityList(Model model) {
        model.addAttribute("activities", activityUsersCounterRepo.CountActivityUsersAndOrderBy("countUsers"));
        model.addAttribute("currentOrderDirection", "DESC");
        model.addAttribute("categories", categoryService.findAll());
        return "adminActivity";
    }

    public List<ActivityUsersCounter> setOrderDirection(List<ActivityUsersCounter> list, String orderDirection) {
        if (!orderDirection.equals("ASC")) Collections.reverse(list);
        return list;
    }

    @GetMapping("/sort")
    public String activityList(Model model,
                               @RequestParam(required = false) String orderField,
                               @RequestParam(required = false) String currentOrderDirection
    ) {
        List<ActivityUsersCounter> usersCounter = activityUsersCounterRepo.CountActivityUsersAndOrderBy(orderField);
        usersCounter = setOrderDirection(usersCounter, currentOrderDirection);
        model.addAttribute("activities", usersCounter);
        model.addAttribute("currentOrderDirection", changeSortingDirection(currentOrderDirection));
        model.addAttribute("categories", categoryService.findAll());
        return "adminActivity";
    }

    @GetMapping("/filter")
    public String filterActivityList(Model model,
                               @RequestParam(required = false) String filter

    ) {
        model.addAttribute("currentOrderDirection", "ASC");
        model.addAttribute("activities", activityService.findByCategoryId(Long.valueOf(filter)));
        model.addAttribute("categories", categoryService.findAll());
        return "adminActivity";
    }

    @PostMapping
    public String addActivity(Map<String, Object> model,
                              Activity activity,
                              @RequestParam Map<String, String> form) {
        try {
            for (String key : form.keySet()) {
                Category category = categoryService.loadCategoryByCategoryname(form.get(key));
                if (category != null) {
                    activity.setCategory(category);
                }
            }
            activityService.save(activity);
            model.put("addCategoryResult", "Activity successfully added");
        } catch (Exception ex) {
            model.put("addCategoryResult", "Activity not added");
        }
        return "redirect:/adminActivity";
    }

    @PostMapping("{id}/time")
    public String userTime(
            @RequestParam("activityId") String activityId,
            @RequestParam("userId") String userId,
            @RequestParam("activity-start") String activityStart,
            @RequestParam("activity-end") String activityEnd
    ){
        UserActivityTime userActivityTime = new UserActivityTime(
                new AdminConfirmationKey(Long.valueOf(userId), Long.valueOf(activityId)),
                userService.findByUserId(Long.valueOf(userId)),
                activityService.findById(Long.valueOf(activityId)),
                LocalDateTime.parse(activityStart), LocalDateTime.parse(activityEnd));
        userActivityTimeService.save(userActivityTime);
        return ("redirect:/adminActivity/" + userId);
    }

}
