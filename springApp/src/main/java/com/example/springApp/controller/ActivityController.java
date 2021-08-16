package com.example.springApp.controller;

import com.example.springApp.domain.*;
import com.example.springApp.repos.ActivityRepo;
import com.example.springApp.repos.CategoryRepo;
import com.example.springApp.repos.UserActivityRepo;
import com.example.springApp.repos.UserActivityTimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping("/adminActivity")
public class ActivityController {

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserActivityRepo userActivityRepo;

    @Autowired
    private UserActivityTimeRepo userActivityTimeRepo;

    @GetMapping("{user}")
    public String userActivityPage(@PathVariable User user,
                                   Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("activities", activityRepo.findAll());
        model.addAttribute("usersActivities", userActivityRepo.findByuserId(user.getId()));
        return "adminActivity";
    }

    public String changeSortingDirection(String currentOrderDirection) {
        return currentOrderDirection.equals("ASC") ? "DESC" : "ASC";
    }

    public Sort getSorting(String orderField, String currentOrderDirection) {
        return Sort.by(Sort.Direction.valueOf(changeSortingDirection(currentOrderDirection)), orderField);
    }

    @GetMapping
    public String activityList(Model model) {
        model.addAttribute("activities", activityRepo.findAll());
        model.addAttribute("currentOrderDirection", "ASC");
        model.addAttribute("categories", categoryRepo.findAll());
        return "adminActivity";
    }

    @GetMapping("/sort")
    public String activityList(Model model,
                               @RequestParam(required = false) String orderField,
                               @RequestParam(required = false) String currentOrderDirection
    ) {
        model.addAttribute("activities", activityRepo.findAll(getSorting(orderField, currentOrderDirection)));
        model.addAttribute("currentOrderDirection", changeSortingDirection(currentOrderDirection));
        model.addAttribute("categories", categoryRepo.findAll());
        return "adminActivity";
    }

    @GetMapping("/filter")
    public String filterActivityList(Model model,
                               @RequestParam(required = false) String filter

    ) {
        System.out.println(filter);
        model.addAttribute("currentOrderDirection", "ASC");
        model.addAttribute("activities", activityRepo.findByCategoryId(Long.valueOf(filter)));
        model.addAttribute("categories", categoryRepo.findAll());
        return "adminActivity";
    }

    @PostMapping
    public String addActivity(Map<String, Object> model,
                              Activity activity,
                              @RequestParam Map<String, String> form) {
        try {
            for (String key : form.keySet()) {
                System.out.println("key: " + key + " value: " + form.get(key));
                if (categoryRepo.findByCategoryname(form.get(key)) != null) {
                    activity.setCategory(categoryRepo.findByCategoryname(form.get(key)));
                }
            }
            activityRepo.save(activity);
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
                LocalDateTime.parse(activityStart), LocalDateTime.parse(activityEnd));
        userActivityTimeRepo.save(userActivityTime);
        return ("redirect:/adminActivity/" + userId);
    }

}
