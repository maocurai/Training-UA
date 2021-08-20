package com.example.springApp.controller;

import com.example.springApp.domain.AdminConfirmationKey;
import com.example.springApp.domain.Status;
import com.example.springApp.domain.UserActivity;
import com.example.springApp.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/userRequests")
    public class RequestController {

    @Autowired
    private UserActivityService userActivityService;


    @GetMapping()
    public String RequestsList(Model model) {
        model.addAttribute("usersActivities", userActivityService
                .findByStatusNotIn(List.of(Status.CONFIRMED, Status.DENIED)));
        return "userRequests";
    }

    @PostMapping("/ad")
    public String confirmActivity(
            @RequestParam("activityId") String activityId,
            @RequestParam("userId") String userId,
            @RequestParam("newActivityStatus") String newActivityStatus
    ) {
        UserActivity userActivity = userActivityService.findById(new AdminConfirmationKey(
                Long.valueOf(userId),
                Long.valueOf(activityId)));
        Status oldStatus = userActivity.getStatus();
        userActivity.setStatus(Status.valueOf(newActivityStatus));
        userActivityService.doActionDueToStatus(userActivity, oldStatus);
        return "redirect:/userRequests";
    }

    @PostMapping("/addActivity")
    public String userRequest(
            @RequestParam("activityId") String activityId,
            @RequestParam("userId") String userId,
            @RequestParam("newActivityStatus") String newActivityStatus
    ) {
        UserActivity userActivity = userActivityService.findById(new AdminConfirmationKey(
                Long.valueOf(userId),
                Long.valueOf(activityId)));
        userActivity.setStatus(Status.valueOf(newActivityStatus));
        userActivityService.save(userActivity);
        return ("redirect:/activity/" + userId);
    }
}
