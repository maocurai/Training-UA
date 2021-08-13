package com.example.springApp.controller;

import com.example.springApp.domain.*;
import com.example.springApp.repos.ActivityRepo;
import com.example.springApp.repos.CategoryRepo;
import com.example.springApp.repos.UserActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/adminActivity")
public class ActivityController {

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserActivityRepo userActivityRepo;

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("activities", activityRepo.findAll());
        model.addAttribute("usersActivities", userActivityRepo.findByuserId(user.getId()));
        return "adminActivity";
    }

//    @GetMapping
//    public String activityList(Model model) {
//        model.addAttribute("activities", activityRepo.findAll());
//        model.addAttribute("categories", categoryRepo.findAll());
//        model.addAttribute("userActivities", userActivityRepo.findAll());
//        return "adminActivity";
//    }

    @PostMapping
    public String addActivity(Map<String, Object> model,
                              Activity activity,
                              @RequestParam Map<String, String> form) {
        try {
            Set<Category> categories = new LinkedHashSet<>();
            activity.setCategoriesOfactivities(categories);
            for (String key : form.keySet()) {
                if (categoryRepo.findByCategoryname(key) != null) {
                    activity.getCategoriesOfactivities().add(categoryRepo.findByCategoryname(key));
                }
            }
            activityRepo.save(activity);
            model.put("addCategoryResult", "Activity successfully added");
        } catch (Exception ex) {
            model.put("addCategoryResult", "Activity not added");
        }
        return "redirect:/adminActivity";
    }
}
