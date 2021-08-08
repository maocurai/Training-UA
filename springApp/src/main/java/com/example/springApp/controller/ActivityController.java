package com.example.springApp.controller;

import com.example.springApp.domain.Activity;
import com.example.springApp.domain.Category;
import com.example.springApp.repos.ActivityRepo;
import com.example.springApp.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/adminActivity")
//@PreAuthorize("hasAuthority('ADMIN')")
public class ActivityController {

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping
    public String activityList(Model model) {
        model.addAttribute("activities", activityRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        return "adminActivity";
    }

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

//    public boolean isPresentCategory(String categoryname) {
//        return categoryRepo.findAll()
//                .stream()
//                .anyMatch(activity->activity.getCategoryname().equals(categoryname));
//    }

//    @GetMapping("{user}")
//    public String userEditForm(@PathVariable User user, Model model) {
//        model.addAttribute("user", user);
//        model.addAttribute("activities", user);
//        return "userEdit";
//    }

//    @PostMapping
//    public String activitySave(
//            @RequestParam String activityname,
//            @RequestParam String catregoryname,
//            @RequestParam Map<String, String> form,
//            @RequestParam("activityId") Activity activity
//    ) {
//        activity.setActivityname(activityname);
////        activity.addCategory();
//        activityRepo.save(activity);
//        return "redirect:/activity";
//    }

}
